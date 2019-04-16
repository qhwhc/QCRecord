package com.service;

import com.pojo.QcRecord;

import net.sf.json.JSONArray;

public interface QcService {
	public boolean add(QcRecord qcRecord);
	public JSONArray get(String file);
	public double getQcRate();
}
