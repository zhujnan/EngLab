package com.wisezone.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wisezone.dao.LeaveDao;
import com.wisezone.entity.Leave;
import com.wisezone.service.LeaveService;

/**
 * 请假单Service实现类
 * @author user
 *
 */
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService{

	@Resource
	private LeaveDao leaveDao;
	
	public Leave findById(Integer id) {
		return leaveDao.findById(id);
	}

	public int add(Leave leave) {
		return leaveDao.add(leave);
	}

	public List<Leave> find(Map<String, Object> map) {
		return leaveDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return leaveDao.getTotal(map);
	}

	public int update(Leave leave) {
		return leaveDao.update(leave);
	}

}
