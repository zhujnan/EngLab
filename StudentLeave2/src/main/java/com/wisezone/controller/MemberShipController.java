package com.wisezone.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisezone.entity.Group;
import com.wisezone.entity.MemberShip;
import com.wisezone.entity.User;
import com.wisezone.service.MemberShipService;
import com.wisezone.util.ResponseUtil;
import com.wisezone.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * �û���ɫ����Controller��
 * @author user
 *
 */
@Controller
@RequestMapping("/memberShip")
public class MemberShipController {

	@Resource
	private MemberShipService memberShipService;
	
	/**
	 * �����û�Ȩ�ޣ���ɾ������������ӣ�
	 * @param userId
	 * @param roleIds
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public String update(String userId,String groupIds,HttpServletResponse response)throws Exception{
		memberShipService.deleteAllGroupsByUserId(userId);
		if(StringUtil.isNotEmpty(groupIds)){
			String idsArr[]=groupIds.split(",");
			for(String groupId:idsArr){
				User user=new User();user.setId(userId);
				Group group=new Group();group.setId(groupId);
				MemberShip memberShip=new MemberShip();memberShip.setUser(user);memberShip.setGroup(group);
				memberShipService.add(memberShip);
			}
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
