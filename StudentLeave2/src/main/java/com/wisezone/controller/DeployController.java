package com.wisezone.controller;

import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/deploy")
public class DeployController {

	@Resource
	private RepositoryService repositoryService;
	
	

	/**
	 * �ϴ����̲����ļ�
	 * @param deployFile
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deploy")
	public String deploy(@RequestParam("deployFile") MultipartFile deployFile,HttpServletResponse response)throws Exception{
		repositoryService.createDeployment() // ��������
		      .name(deployFile.getOriginalFilename())  // ��������
		      .addZipInputStream(new ZipInputStream(deployFile.getInputStream()))  // ���zip��������
              .deploy(); // ����
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ���̲����ѯ
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
		List<Deployment> deploymentList=repositoryService.createDeploymentQuery() // �������̲����ѯ
				    .orderByDeploymenTime().desc() // ���ݲ���ʱ�併������
				    .deploymentNameLike("%"+s_name+"%") // ���ݲ�������ģ����ѯ
					.listPage(pageBean.getStart(),pageBean.getPageSize()); // ���ش���ҳ�Ľ������      
		long total=repositoryService.createDeploymentQuery().deploymentNameLike("%"+s_name+"%").count(); // ��ȡ�ܼ�¼��
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"resources"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(deploymentList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * ɾ�����̲���
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			repositoryService.deleteDeployment(idsStr[i], true);
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
