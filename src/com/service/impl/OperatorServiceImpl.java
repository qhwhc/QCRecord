package com.service.impl;

import com.dao.OperatorDao;
import com.dao.impl.OperatorDaoImpl;
import com.service.OperatorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

public class OperatorServiceImpl implements OperatorService {
	private OperatorDao OperatorDao = new OperatorDaoImpl();
	private Log logger = LogFactory.getLog(OperatorService.class);
	@Override
	public String[] getList() {
		logger.info("Project Root Dir:" + System.getProperty("user.dir"));
		return OperatorDao.getList(System.getProperty("user.dir") + "/record_data/operator");
	}
	@Override
	public boolean delete(String name) {
		return OperatorDao.delete(System.getProperty("user.dir") + "/record_data/operator", name);
	}
	@Override
	public void save(String names) {
		OperatorDao.save(System.getProperty("user.dir")+ "/record_data/operator", names);
	}
}
