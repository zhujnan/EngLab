package com.wisezone.service;

import java.util.List;
import java.util.Map;

import com.wisezone.entity.Leave;

/**
 * ��ٵ�Service
 * @author user
 *
 */
public interface LeaveService {

	/**
	 * ͨ��id��ѯ��ٵ�ʵ��
	 * @param id
	 * @return
	 */
	public Leave findById(Integer id);
	
	/**
	 * �����ٵ�
	 * @param leave
	 * @return
	 */
	public int add(Leave leave);
	
	/**
	 * �޸���ٵ�
	 * @param leave
	 * @return
	 */
	public int update(Leave leave);
	
	/**
	 * ����������ѯ��ٵ�����
	 * @param map
	 * @return
	 */
	public List<Leave> find(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}
