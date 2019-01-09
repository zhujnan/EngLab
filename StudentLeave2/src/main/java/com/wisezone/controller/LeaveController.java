package com.wisezone.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wisezone.entity.Leave;
import com.wisezone.entity.PageBean;
import com.wisezone.entity.User;
import com.wisezone.service.LeaveService;
import com.wisezone.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 请假Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Resource
	private LeaveService leaveService;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private TaskService taskService;
	
	/**
	 * 分页查询请假
	 * @param page
	 * @param rows
	 * @param userId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,String userId,HttpServletResponse response)throws Exception{
		/*
		 * 客户端请求：
		 * leave/list.do?userId=${currentMemberShip.user.id }
		 * 	
		 * 服务端响应一个Json字符串需要满足如下条件：
		 * 		1.必须要是分页查询
		 * 		2.当前用户的申请
		 * 		3.总记录数
		 */
		//1、构建分页查询条件
		System.out.println("userId的值为"+userId);
		System.out.println("page的值为"+page);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println("每页的开始位置"+pageBean.getStart());
		System.out.println("每页的显示行数"+pageBean.getPageSize());
		map.put("userId", userId);//根据当前系统用户Id来查询其名下的请假流程
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Leave> leaveList=leaveService.find(map); //得到查询结果
		Long total=leaveService.getTotal(map); //获取总记录数字(分页查询所有页面必备)
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		//用来处理日期
		JSONObject result=new JSONObject(); 
		JSONArray jsonArray=JSONArray.fromObject(leaveList,jsonConfig);
		//将集合对象中的日期进行处理，得到一个新的json数组
		result.put("rows", jsonArray); //将jsonArray数组绑定到result这个json对象
		result.put("total", total);//将总记录数绑定到result这个json对象
		ResponseUtil.write(response, result);  //响应给请求
		return null;
	}

	
	/**
	 * 发起请假申请 修改请假单状态 
	 * @param leaveId 请假单编号
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/startApply")
	public String startApply(Integer leaveId,HttpServletResponse response)throws Exception{
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("leaveId", leaveId); //流程实例ID
		/*
		 *  启动流程 
     		RuntimeServcie中也为我们提供了很多启动流程的方法，
     		方法统一命名为startProcessInstanceByXXX，
     		其中XXX有流程定义ID、流程定义的key
     		（流程描述文件中的process的id属性）和流程中定义的额message
		 */
		ProcessInstance pi=runtimeService.
					startProcessInstanceByKey("studentLeaveProcess", variables); 
		//1.启动流程
		Task task=taskService.createTaskQuery()
				.processInstanceId(pi.getProcessInstanceId()).singleResult(); 
		//2.根据流程实例id查询任务
		taskService.complete(task.getId()); 
		//3.完成 学生填写请假单任务
		Leave leave=leaveService.findById(leaveId); 
		leave.setState("审核中"); 
		leave.setProcessInstanceId(pi.getProcessInstanceId());
		//4.根据id查询请假单，并将请假单中的属性设置为审核中
		//并设置流程实例id
		leaveService.update(leave); // 修改请假单状态
		//5.将请假单对象作为参数，修改数据库中的数据
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * 添加请假单
	 * @param leave
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	//点击保存，会将表单中的值，与leave对象中的属性值映射
	@RequestMapping("/save")
	public String save( HttpServletRequest  req ,Leave leave,HttpServletResponse response)throws Exception{
		System.out.println("hh");
		int resultTotal=0; // 操作的记录条数
		leave.setLeaveDate(new Date());  //设置当前系统时间
		System.out.println(req.getParameter("userId"));
		User u = new User();
		u.setId(req.getParameter("userId"));
		leave.setUser(u);
		System.out.println(leave);
		resultTotal=leaveService.add(leave);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 通过任务id获取请假单
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getLeaveByTaskId")
	public String getLeaveByTaskId(String taskId,HttpServletResponse response)throws Exception{
		Integer leaveId=(Integer) taskService.getVariable(taskId, "leaveId");
		Leave leave=leaveService.findById(leaveId);
		JSONObject result=new JSONObject();
		result.put("leave", JSONObject.fromObject(leave));
		ResponseUtil.write(response, result);
		return null;
	}
	
}
