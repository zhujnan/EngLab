package com.wisezone.dao;


import java.util.List;
import java.util.Map;

import com.wisezone.entity.User;

/**
 * �û�Dao
 * @author user
 *
 */
public interface UserDao {

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
