package com.wisezone.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wisezone.entity.Group;
import com.wisezone.entity.Leave;
import com.wisezone.entity.MemberShip;
import com.wisezone.entity.MyTask;
import com.wisezone.entity.PageBean;
import com.wisezone.entity.User;
import com.wisezone.service.LeaveService;
import com.wisezone.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * ����Controller��
 * @author user
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {

	@Resource
	private TaskService taskService;
	
	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private FormService formService;
	
	@Resource
	private LeaveService leaveService;
	
	@Resource
	private HistoryService historyService;

	/**
	 * �����û�id��ҳ��ѯ����
	 * @param page
	 * @param rows
	 * @param userId �û�id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,
				@RequestParam(value="rows",required=false)String rows,
				String s_taskName,
				String userId,
				HttpServletResponse response)throws Exception{
		System.out.println(userId+"-----------------------");
		if(s_taskName==null){
			s_taskName="";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<Task> list=taskService.createTaskQuery()  // ���������ѯ
				.taskCandidateUser(userId) // �����û�id��ѯ
				.taskNameLike("%"+s_taskName+"%") // ������������ģ����ѯ
				.listPage(pageBean.getStart(),pageBean.getPageSize()); // ���ش���ҳ�Ľ������ 
		//��ҳ��ѯ�������
		List<MyTask> taskList=new ArrayList<MyTask>();
		for(Task t:list){
			MyTask myTask=new MyTask();
			myTask.setId(t.getId());
			myTask.setName(t.getName());
			myTask.setCreateTime(t.getCreateTime());
			taskList.add(myTask);
        }
		long total=taskService.createTaskQuery().taskCandidateUser(userId).taskNameLike("%"+s_taskName+"%").count(); // ��ȡ�ܼ�¼��
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(taskList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ����ʵ���Ѿ��������ʷ����
	 * @param page
	 * @param rows
	 * @param s_taskName
	 * @param groupId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/finishedList")
	public String finishedList(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,String s_taskName,String groupId,HttpServletResponse response)throws Exception{
		if(s_taskName==null){
			s_taskName="";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<HistoricTaskInstance> htiList=historyService.createHistoricTaskInstanceQuery() // ������ʷ����ʵ����ѯ
				.taskCandidateGroup(groupId) // ���ݽ�ɫ��ѯ
				.taskNameLike("%"+s_taskName+"%") // ������������ģ����ѯ
				.listPage(pageBean.getStart(),pageBean.getPageSize()); // ���ش���ҳ�Ľ������
		List<MyTask> taskList=new ArrayList<MyTask>();
		int t=0; // �����������ĸ���
		for(HistoricTaskInstance hti:htiList){
			// ����������Ӧ������ʵ��������ʱ��������ѯ������˵�������������ʵ���Ѿ�����
		    if(taskService.createTaskQuery().processInstanceId(hti.getProcessInstanceId()).singleResult()==null){  
		    	MyTask myTask=new MyTask();
		    	myTask.setId(hti.getId());
		    	myTask.setName(hti.getName());
		    	myTask.setCreateTime(hti.getCreateTime());
		    	myTask.setEndTime(hti.getEndTime());
		    	taskList.add(myTask);
		    }else{
		    	t++;
		    }
        }
		long total=historyService.createHistoricTaskInstanceQuery().taskCandidateGroup(groupId).taskNameLike("%"+s_taskName+"%").count(); // ��ȡ�ܼ�¼��
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(taskList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total-t);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * ����ʵ��δ�������ʷ���� �Ѱ�����
	 * @param page
	 * @param rows
	 * @param s_taskName
	 * @param groupId
	 * @param userId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/unFinishedList")
	public String unFinishedList(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,String s_taskName,String groupId,String userId,HttpServletResponse response)throws Exception{
		System.out.println("�Ѱ�����");
		if(s_taskName==null){
			s_taskName="";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<HistoricTaskInstance> htiList=historyService.createHistoricTaskInstanceQuery() // ������ʷ����ʵ����ѯ
				.taskCandidateGroup(groupId) // ���ݽ�ɫ��ѯ
				.taskNameLike("%"+s_taskName+"%") // ������������ģ����ѯ
				.listPage(pageBean.getStart(),pageBean.getPageSize()); // ���ش���ҳ�Ľ������
		List<MyTask> taskList=new ArrayList<MyTask>();
		int t=0; // �����������ĸ���
		for(HistoricTaskInstance hti:htiList){
			// ����������Ӧ������ʵ��������ʱ��������ѯ����˵�������������ʵ��δ����  �������û�id�Լ�����id������ʱ����������ѯ�������  �������Ѱ�����
		    if((taskService.createTaskQuery().processInstanceId(hti.getProcessInstanceId()).singleResult()!=null)
		    		&&(taskService.createTaskQuery().taskCandidateUser(userId).taskId(hti.getId()).list().size()==0)){  
		    	MyTask myTask=new MyTask();
		    	myTask.setId(hti.getId());
		    	myTask.setName(hti.getName());
		    	myTask.setCreateTime(hti.getCreateTime());
		    	myTask.setEndTime(hti.getEndTime());
		    	taskList.add(myTask);
		    }else{
		    	t++;
		    }
        }
		long total=historyService.createHistoricTaskInstanceQuery().taskCandidateGroup(groupId).taskNameLike("%"+s_taskName+"%").count(); // ��ȡ�ܼ�¼��
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(taskList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total-t);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ��ѯ��ǰ����ͼ 
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showCurrentView")
	public ModelAndView showCurrentView(String taskId,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView(); 
		// ͨ������id��ѯ���̶���
		Task task=taskService.createTaskQuery() // ���������ѯ
				.taskId(taskId) // ��������id��ѯ
				.singleResult();
		String processDefinitionId=task.getProcessDefinitionId(); // ��ȡ���̶���id
		ProcessDefinition processDefinition=repositoryService.createProcessDefinitionQuery() // �������̶����ѯ
					.processDefinitionId(processDefinitionId) // �������̶���id��ѯ
					.singleResult();
		mav.addObject("deploymentId",processDefinition.getDeploymentId()); // ����id
		mav.addObject("diagramResourceName", processDefinition.getDiagramResourceName()); // ͼƬ��Դ�ļ�����
		
		// �鿴��ǰ�����
		ProcessDefinitionEntity processDefinitionEntity =(ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
		String processInstanceId = task.getProcessInstanceId(); // ��ȡ����ʵ��id
		// ��������ʵ��id��ѯ�ʵ��
		ProcessInstance pi =runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId) 
				.singleResult();
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(pi.getActivityId()); // ���ݻid��ѯ�ʵ��
		mav.addObject("x", activityImpl.getX());
		mav.addObject("y", activityImpl.getY());
		mav.addObject("width", activityImpl.getWidth());
		mav.addObject("height", activityImpl.getHeight());
		mav.setViewName("page/currentView");
		return mav;
	}
	
	/**
	 * ��ѯ��ǰ����ͼ �����õ�
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showHisCurrentView")
	public ModelAndView showHisCurrentView(String taskId,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView(); 
		HistoricTaskInstance hti=historyService
						.createHistoricTaskInstanceQuery()
							.taskId(taskId)
								.singleResult(); //��ȡ��ʷ����ʵ������
		String processDefinitionId=hti.getProcessDefinitionId(); // ��ȡ���̶���id
		ProcessDefinition processDefinition=repositoryService
				.createProcessDefinitionQuery() // �������̶����ѯ
					.processDefinitionId(processDefinitionId) 
					// �������̶���id��ѯ
					.singleResult();
		mav.addObject("deploymentId",processDefinition.getDeploymentId()); // ����id
		mav.addObject("diagramResourceName", 
					processDefinition.getDiagramResourceName()); // ͼƬ��Դ�ļ�����
		// �鿴��ǰ�����
		ProcessDefinitionEntity processDefinitionEntity =
				(ProcessDefinitionEntity) 
				repositoryService.getProcessDefinition(processDefinitionId);
		String processInstanceId = hti.getProcessInstanceId(); // ��ȡ����ʵ��id
		// ��������ʵ��id��ѯ�ʵ��
		ProcessInstance pi =runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId) 
				.singleResult();
		ActivityImpl activityImpl = 
				processDefinitionEntity
				.findActivity(pi.getActivityId()); // ���ݻid��ѯ�ʵ��
		mav.addObject("x", activityImpl.getX());
		mav.addObject("y", activityImpl.getY());
		mav.addObject("width", activityImpl.getWidth());
		mav.addObject("height", activityImpl.getHeight());
		mav.setViewName("page/currentView");
		return mav;
	}
	
	
	/**
	 * �ض�����˴���ҳ��
	 * @param taskId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectPage")
	public String redirectPage(String taskId,HttpServletResponse response)throws Exception{
		/*
		 * https://blog.csdn.net/whatlookingfor/article/details/52998861
		 * activiti�ṩ��FormService��API�������Ի�ȡ����������
		 * �ڵ�ı������Լ�����ڵ�ı�����
		 */
		TaskFormData formData = formService.getTaskFormData(taskId);
		//�������̶���Id��ȡ���������ڵ�ı�����
		String url = formData.getFormKey(); 
		//��ȡaudit_Id.jsp
		System.out.println("·����ַΪ��"+url);
		JSONObject result=new JSONObject();
		result.put("url", url);
		ResponseUtil.write(response, result);
		return null;
	}
	

	/**
	 * �೤����
	 * @param taskId ����id
	 * @param leaveDays �������
	 * @param comment ��ע��Ϣ 
	 * @param state ���״̬ 1 ͨ�� or 2 ����
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/audit_bz")
	public String audit_bz(String taskId,Integer leaveDays,String comment,Integer state,HttpServletResponse response,HttpSession session)throws Exception{
		// ͨ������id��ѯ���̶���
		System.out.println("�೤����"+taskId+leaveDays+comment+state);
		Task task=taskService.createTaskQuery() // ���������ѯ
				.taskId(taskId) // ��������id��ѯ
				.singleResult();
		Map<String, Object> variables=new HashMap<String,Object>();
		if(state==1){
			variables.put("msg", "ͨ��");			
		}else if(state==2){
			Integer leaveId=(Integer) taskService.getVariable(taskId, "leaveId"); // ͨ������id��ȡ��ٵ�id
			Leave leave=leaveService.findById(leaveId);
			leave.setState("���δͨ��");
			leaveService.update(leave); // ���������Ϣ
			variables.put("msg", "δͨ��");	
		}
		variables.put("days", leaveDays); // ���̱���ֵ
		String processInstanceId = task.getProcessInstanceId(); // ��ȡ����ʵ��id
	/*	MemberShip currentMemberShip=(MemberShip)session.getAttribute("currentMemberShip");
		User currentUser=currentMemberShip.getUser();
		Group currentGroup=currentMemberShip.getGroup();*/
		 Session sess = SecurityUtils.getSubject().getSession();
		 String firstname = (String) sess.getAttribute("firstName");
		 String lastname = (String) sess.getAttribute("lastName");
		 String group = (String)sess.getAttribute("group");
		 System.out.println("________"+firstname+lastname+group);
		Authentication.setAuthenticatedUserId(
				 firstname
				+lastname
				+"��"+group+"��");// �����û�id
		taskService.addComment(taskId, processInstanceId, comment); // �����ע��Ϣ
		taskService.complete(taskId, variables); // �������
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * �쵼����
	 * @param taskId ����id
	 * @param leaveDays �������
	 * @param comment ��ע��Ϣ 
	 * @param state ���״̬ 1 ͨ�� or 2 ����
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/audit_ld")
	public String audit_ld(String taskId,Integer leaveDays,String comment,Integer state,HttpServletResponse response,HttpSession session)throws Exception{
		// ͨ������id��ѯ���̶���
		System.out.println("�쵼״̬"+state);
		Task task=taskService.createTaskQuery() // ���������ѯ
				.taskId(taskId) // ��������id��ѯ
				.singleResult();
		Map<String, Object> variables=new HashMap<String,Object>();
		Integer leaveId=(Integer) taskService.getVariable(taskId, "leaveId"); // ͨ������id��ȡ��ٵ�id
		Leave leave=leaveService.findById(leaveId);
		if(state==1){
			leave.setState("���ͨ��");
			leaveService.update(leave); // ���������Ϣ		
		}else if(state==2){
			leave.setState("���δͨ��");
			leaveService.update(leave); // ���������Ϣ
		}
		String processInstanceId = task.getProcessInstanceId(); // ��ȡ����ʵ��id
/*		MemberShip currentMemberShip=(MemberShip)session.getAttribute("currentMemberShip");
		User currentUser=currentMemberShip.getUser();
		Group currentGroup=currentMemberShip.getGroup();*/
		 Session sess = SecurityUtils.getSubject().getSession();
		 String firstname = (String) sess.getAttribute("firstName");
		 String lastname = (String) sess.getAttribute("lastName");
		 String group = (String)sess.getAttribute("group");
		Authentication.setAuthenticatedUserId(firstname+ lastname+"��"+group+"��");// �����û�id
		taskService.addComment(taskId, processInstanceId, comment); // �����ע��Ϣ
		taskService.complete(taskId, variables); // �������
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	
	/**
	 * ��ʷ��ע 
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listHistoryComment")
	public String listHistoryComment(String taskId,HttpServletResponse response)throws Exception{
		System.out.println("4444");
		if(taskId==null){
			return null;
		}
		HistoricTaskInstance hti=historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		String processInstanceId = hti.getProcessInstanceId(); // ��ȡ����ʵ��id
		List<Comment> commentList=taskService.getProcessInstanceComments(processInstanceId);
		Collections.reverse(commentList); // ����Ԫ�ط�ת
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(commentList,jsonConfig);
		System.out.println("�鿴��ʷ��ע");
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * ��ʷ��ע ͨ������ʵ��id
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listHistoryCommentWithProcessInstanceId")
	public String listHistoryCommentWithProcessInstanceId(String processInstanceId,HttpServletResponse response)throws Exception{
		if(processInstanceId==null){
			return null;
		}
		System.out.println("���ʳ�¯"+processInstanceId);
		List<Comment> commentList=taskService.getProcessInstanceComments(processInstanceId);
		Collections.reverse(commentList); // ����Ԫ�ط�ת
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(commentList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
}
