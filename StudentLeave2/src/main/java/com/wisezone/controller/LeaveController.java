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
 * ���Controller��
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
	 * ��ҳ��ѯ���
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
		 * �ͻ�������
		 * leave/list.do?userId=${currentMemberShip.user.id }
		 * 	
		 * �������Ӧһ��Json�ַ�����Ҫ��������������
		 * 		1.����Ҫ�Ƿ�ҳ��ѯ
		 * 		2.��ǰ�û�������
		 * 		3.�ܼ�¼��
		 */
		//1��������ҳ��ѯ����
		System.out.println("userId��ֵΪ"+userId);
		System.out.println("page��ֵΪ"+page);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println("ÿҳ�Ŀ�ʼλ��"+pageBean.getStart());
		System.out.println("ÿҳ����ʾ����"+pageBean.getPageSize());
		map.put("userId", userId);//���ݵ�ǰϵͳ�û�Id����ѯ�����µ��������
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Leave> leaveList=leaveService.find(map); //�õ���ѯ���
		Long total=leaveService.getTotal(map); //��ȡ�ܼ�¼����(��ҳ��ѯ����ҳ��ر�)
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		//������������
		JSONObject result=new JSONObject(); 
		JSONArray jsonArray=JSONArray.fromObject(leaveList,jsonConfig);
		//�����϶����е����ڽ��д����õ�һ���µ�json����
		result.put("rows", jsonArray); //��jsonArray����󶨵�result���json����
		result.put("total", total);//���ܼ�¼���󶨵�result���json����
		ResponseUtil.write(response, result);  //��Ӧ������
		return null;
	}

	
	/**
	 * ����������� �޸���ٵ�״̬ 
	 * @param leaveId ��ٵ����
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/startApply")
	public String startApply(Integer leaveId,HttpServletResponse response)throws Exception{
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("leaveId", leaveId); //����ʵ��ID
		/*
		 *  �������� 
     		RuntimeServcie��ҲΪ�����ṩ�˺ܶ��������̵ķ�����
     		����ͳһ����ΪstartProcessInstanceByXXX��
     		����XXX�����̶���ID�����̶����key
     		�����������ļ��е�process��id���ԣ��������ж���Ķ�message
		 */
		ProcessInstance pi=runtimeService.
					startProcessInstanceByKey("studentLeaveProcess", variables); 
		//1.��������
		Task task=taskService.createTaskQuery()
				.processInstanceId(pi.getProcessInstanceId()).singleResult(); 
		//2.��������ʵ��id��ѯ����
		taskService.complete(task.getId()); 
		//3.��� ѧ����д��ٵ�����
		Leave leave=leaveService.findById(leaveId); 
		leave.setState("�����"); 
		leave.setProcessInstanceId(pi.getProcessInstanceId());
		//4.����id��ѯ��ٵ���������ٵ��е���������Ϊ�����
		//����������ʵ��id
		leaveService.update(leave); // �޸���ٵ�״̬
		//5.����ٵ�������Ϊ�������޸����ݿ��е�����
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * �����ٵ�
	 * @param leave
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	//������棬�Ὣ���е�ֵ����leave�����е�����ֵӳ��
	@RequestMapping("/save")
	public String save( HttpServletRequest  req ,Leave leave,HttpServletResponse response)throws Exception{
		System.out.println("hh");
		int resultTotal=0; // �����ļ�¼����
		leave.setLeaveDate(new Date());  //���õ�ǰϵͳʱ��
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
	 * ͨ������id��ȡ��ٵ�
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
