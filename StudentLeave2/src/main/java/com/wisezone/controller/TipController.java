package com.wisezone.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisezone.entity.Tip;
import com.wisezone.service.TipService;
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
@RequestMapping("/tap")
public class TipController {
	@Resource()
	private TipService tipService;

	/**
	 * 
	 * �����û���ѯ��ǰ�û���ص��ճ̣�
	 *  �Լ�����Ա��ӵ���־
	 * @param userId �û�id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(String userId,
				HttpServletResponse response)throws Exception{
		ArrayList<Tip> Tip =tipService.getTips(userId);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[] {"userId"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(Tip,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	@RequestMapping("/save")
	public String save(Tip tip,
				HttpServletResponse response)throws Exception{
		int length = tipService.saveTip(tip);
		if(length>=1) {
			JSONObject result=new JSONObject();
			result.put("data", true);
			ResponseUtil.write(response, result);
		}
		System.out.println("tip����");
		System.out.println(tip);
		return null;
	}
	@RequestMapping("/del")
	public String del(Tip tip,
				HttpServletResponse response)throws Exception{
		System.out.println("tipɾ��");
		System.out.println(tip);
		boolean b = tipService.deleteTip(tip);
		JSONObject result=new JSONObject();
		result.put("data", b);
		ResponseUtil.write(response, result);
		return null;
	}
}
