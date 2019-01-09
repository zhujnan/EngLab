package com.wisezone.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wisezone.dao.GroupDao;
import com.wisezone.entity.Group;
import com.wisezone.service.GroupService;

/**
 * 角色Service实现类
 * @author user
 *
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService{

	@Resource
	private GroupDao groupDao;
	
	public Group findById(String id) {
		return groupDao.findById(id);
	}

	public List<Group> find(Map<String, Object> map) {
		return groupDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return groupDao.getTotal(map);
	}

	public int update(Group group) {
		return groupDao.update(group);
	}

	public int add(Group group) {
		return groupDao.add(group);
	}

	public int delete(String id) {
		return groupDao.delete(id);
	}

	public List<Group> findByUserId(String userId) {
		return groupDao.findByUserId(userId);
	}

}
