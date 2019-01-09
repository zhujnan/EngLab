package com.wisezone.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wisezone.entity.PageBean;
import com.wisezone.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * �������Controller��
 * @author user
 *
 */
@Controller
@RequestMapping("/processDefinition")
public class ProcessDefinitionController {

	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private HistoryService historyService;
	
	/**
	 * ���̶����ѯ
	 * @param page
	 * @param rows
	 * @param name
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,String s_name,HttpServletResponse response)throws Exception{
		if(s_name==null){
			s_name="";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<ProcessDefinition> pdList=repositoryService.createProcessDefinitionQuery() // �������̶����ѯ
				    .orderByProcessDefinitionKey().desc() // �������̶���id��������
				    .processDefinitionNameLike("%"+s_name+"%") // �������̶�������ģ����ѯ
					.listPage(pageBean.getStart(),pageBean.getPageSize()); // ���ش���ҳ�Ľ������      
		long total=repositoryService.createProcessDefinitionQuery().processDefinitionNameLike("%"+s_name+"%").count(); // ��ȡ�ܼ�¼��
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"identityLinks","processDefinition"});
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(pdList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * �鿴����ͼ
	 * @param deploymentId
	 * @param diagramResourceName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showView")
	public String showView(String deploymentId,String diagramResourceName,HttpServletResponse response)throws Exception{
		InputStream inputStream=repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
		OutputStream out =response.getOutputStream();
		for(int b=-1;(b=inputStream.read())!=-1;){
			out.write(b);
		}
		out.close();
		inputStream.close();
		return null;
	}
	
	/**
	 * ��������id��ʾ����ͼ
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showViewByTaskId")
	public String showViewByTaskId(String taskId,HttpServletResponse response)throws Exception{
		HistoricTaskInstance hti=historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		String processDefinitionId=hti.getProcessDefinitionId(); // ��ȡ���̶���id
		ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
		InputStream inputStream=repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());
		OutputStream out =response.getOutputStream();
		for(int b=-1;(b=inputStream.read())!=-1;){
			out.write(b);
		}
		out.close();
		inputStream.close();
		return null;
	}
}
