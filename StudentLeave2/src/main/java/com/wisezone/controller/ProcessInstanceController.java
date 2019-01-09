package com.wisezone.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisezone.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * ����ʵ��Controller��
 * @author user
 *
 */
@Controller
@RequestMapping("/processInstance")
public class ProcessInstanceController {

	@Resource
	private HistoryService historyService;
	
	/**
	 * ��������id��ѯ������ʵ����ִ�й���
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listAction")
	public String listAction(String taskId,HttpServletResponse response)throws Exception{
		if(taskId==null){
			return null;
		}
		HistoricTaskInstance hti=historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		String processInstanceId = hti.getProcessInstanceId(); // ��ȡ����ʵ��id
		List<HistoricActivityInstance> hciList=historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(hciList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	

}
