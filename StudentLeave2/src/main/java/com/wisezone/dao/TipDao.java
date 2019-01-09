package com.wisezone.dao;

import java.util.ArrayList;

import com.wisezone.entity.Tip;

public interface TipDao {

	ArrayList<Tip> getTips(String userId);

	int saveTip(Tip tip);

	boolean deleteTip(Tip tip);
	
}
