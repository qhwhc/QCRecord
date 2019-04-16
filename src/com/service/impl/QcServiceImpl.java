package com.service.impl;

import java.util.Date;

import com.common.util.DateUtil;
import com.dao.QcDao;
import com.dao.impl.QcDaoImpl;
import com.pojo.QcRecord;
import com.service.QcService;

import net.sf.json.JSONArray;

public class QcServiceImpl implements QcService {
	private QcDao qcDao= new QcDaoImpl();
	@Override
	public boolean add(QcRecord qcRecord) {
		return qcDao.add(qcRecord);
	}
	
	@Override
	public JSONArray get(String file) {
		return qcDao.get(System.getProperty("user.dir") + "/record_data/" + file);
	}

	@Override
	public double getQcRate() {
		double qcRate = 0;
		JSONArray jsonArray = get(DateUtil.toString(new Date()));
		String isQc = "";
		for (int i = 0,j = jsonArray.size(); i < j; i++) {
			isQc = jsonArray.getJSONObject(i).getString("id");
			if("QC".equals(isQc)) {
				qcRate = Double.parseDouble(jsonArray.getJSONObject(i).getString("qcRate"));
			}
		}
		return qcRate;
	}

}
