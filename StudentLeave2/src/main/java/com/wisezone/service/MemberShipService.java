package com.wisezone.service;

import java.util.Map;

import com.wisezone.entity.MemberShip;

/**
 * �û���ɫ��ϵService
 * @author user
 *
 */
public interface MemberShipService {

	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public MemberShip login(Map<String,Object> map);
	
	/**
	 * ɾ��ָ���û����н�ɫ
	 * @param userId
	 * @return
	 */
	public int  deleteAllGroupsByUserId(String userId);
	
	/**
	 * ����û�Ȩ��
	 * @param userRole
	 * @return
	 */
	public int add(MemberShip memberShip);
}
