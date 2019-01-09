package com.wisezone.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wisezone.dao.TipDao;
import com.wisezone.entity.Tip;
import com.wisezone.service.TipService;
@Service("tipService")
public class TipServiceImpl  implements TipService{
	@Resource
	private TipDao tipDao;
	public ArrayList<Tip> getTips(String userId) {
		return tipDao.getTips(userId);
	}
	public int saveTip(Tip tip) {
		return tipDao.saveTip(tip);
	}
	public boolean deleteTip(Tip tip) {
		System.out.println("daoÉ¾³ý"+tip);
		return tipDao.deleteTip(tip);
	}

}
