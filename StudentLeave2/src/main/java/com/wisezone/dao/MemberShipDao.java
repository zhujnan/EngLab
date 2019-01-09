package com.wisezone.dao;

import java.util.Map;

import com.wisezone.entity.MemberShip;

/**
 * �û���ɫ��ϵDao
 * @author user
 *
 */
public interface MemberShipDao {

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
