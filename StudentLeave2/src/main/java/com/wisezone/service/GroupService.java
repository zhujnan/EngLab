package com.wisezone.service;

import java.util.List;
import java.util.Map;

import com.wisezone.entity.Group;

/**
 * 角色Service接口
 * @author user
 *
 */
public interface GroupService {

	/**
	 * 通过id查询角色实体
	 * @param id
	 * @return
	 */
	public Group findById(String id);
	
	
	/**
	 * 通过用户id查询角色集合
	 * @param userId
	 * @return
	 */
	public List<Group> findByUserId(String userId);
	
	
	
	/**
	 * 根据条件查询角色集合
	 * @param map
	 * @return
	 */
	public List<Group> find(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 修改角色
	 * @param user
	 * @return
	 */
	public int update(Group group);
	
	/**
	 * 添加角色
	 * @param user
	 * @return
	 */
	public int add(Group group);
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	public int delete(String id);
}
