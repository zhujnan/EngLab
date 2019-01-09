package com.wisezone.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wisezone.dao.UserDao;
import com.wisezone.entity.User;
import com.wisezone.service.UserService;

/**
 * 用户Service实现类
 * @author user
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User findById(String id) {
		return userDao.findById(id);
	}

	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	public int update(User user) {
		return userDao.update(user);
	}

	public int add(User user) {
		return userDao.add(user);
	}

	public int delete(String id) {
		return userDao.delete(id);
	}

}
