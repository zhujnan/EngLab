package com.wisezone.service;

import java.util.ArrayList;
import javax.annotation.Resource;
import com.wisezone.dao.TipDao;
import com.wisezone.entity.Tip;

public interface TipService {
	@Resource
	ArrayList<Tip> getTips(String userId);
	@Resource
	int saveTip(Tip tip);
	@Resource
	boolean deleteTip(Tip tip);
}
