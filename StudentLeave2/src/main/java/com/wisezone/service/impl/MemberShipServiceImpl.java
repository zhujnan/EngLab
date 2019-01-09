package com.wisezone.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wisezone.dao.MemberShipDao;
import com.wisezone.entity.MemberShip;
import com.wisezone.service.MemberShipService;

/**
 * �û���ɫ��ϵServiceʵ����
 * @author user
 *
 */
@Service("memberShipService")
public class MemberShipServiceImpl implements MemberShipService{

	@Resource
	private MemberShipDao memberShipDao;
	
	/**
	 * �û���¼
	 */
	public MemberShip login(Map<String, Object> map) {
		return memberShipDao.login(map);
	}

	public int deleteAllGroupsByUserId(String userId) {
		return memberShipDao.deleteAllGroupsByUserId(userId);
	}

	public int add(MemberShip memberShip) {
		return memberShipDao.add(memberShip);
	}

}
