package com.wisezone.service;

import java.util.Map;

import com.wisezone.entity.MemberShip;

/**
 * 用户角色关系Service
 * @author user
 *
 */
public interface MemberShipService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public MemberShip login(Map<String,Object> map);
	
	/**
	 * 删除指定用户所有角色
	 * @param userId
	 * @return
	 */
	public int  deleteAllGroupsByUserId(String userId);
	
	/**
	 * 添加用户权限
	 * @param userRole
	 * @return
	 */
	public int add(MemberShip memberShip);
}
