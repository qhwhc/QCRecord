package com.dao;

import com.pojo.QcRecord;

import net.sf.json.JSONArray;

public interface QcDao {
	public boolean add(QcRecord qcRecord);
	public JSONArray get(String FilePath);
}
