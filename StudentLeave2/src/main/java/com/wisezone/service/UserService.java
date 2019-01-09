package com.wisezone.service;

import java.util.List;

import java.util.Map;

import com.wisezone.entity.User;

/**
 * �û�Service
 * @author user
 *
 */
public interface UserService {

	/**
	 * ͨ��id��ѯ�û�ʵ��
	 * @param id
	 * @return
	 */
	public User findById(String id);
	
	/**
	 * ����������ѯ�û�����
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int update(User user);
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public int delete(String id);
}
