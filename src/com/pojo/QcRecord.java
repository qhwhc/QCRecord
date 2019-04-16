package com.pojo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.FileUtil;
import com.service.impl.QcServiceImpl;

public class QcRecord {
	private boolean qcFlag;
	private String id;
	private double preValue;
	private double afterValue;
	private double qcTime;
	private String operater;
	
	public double getWorkTime() {
		DecimalFormat df = new DecimalFormat("#.00");
		if(FileUtil.isEmpty()) {
			return 0;
		}
		double qcRate = new QcServiceImpl().getQcRate();
		if(qcRate == 0) {
			return 0;
		}
		return Double.valueOf(df.format(((preValue - afterValue) * 60 /qcRate )));
	}
	
	public void setWorkTime(String WorkTime) {
		
	}

	

	public boolean isQcFlag() {
		return qcFlag;
	}

	public void setQcFlag(boolean qcFlag) {
		this.qcFlag = qcFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public double getPreValue() {
		return preValue;
	}

	public void setPreValue(double double1) {
		this.preValue = double1;
	}

	public double getAfterValue() {
		return afterValue;
	}

	public void setAfterValue(Double afterValue) {
		this.afterValue = afterValue;
	}

	public double getQcTime() {
		return qcTime;
	}

	public void setQcTime(Double qcTime) {
		this.qcTime = qcTime;
	}

	public Double getQcRate() {
		DecimalFormat df = new DecimalFormat("#.00");
		if(!isQcFlag()) {
			return new QcServiceImpl().getQcRate();
		}
		return Double.valueOf(df.format((preValue - afterValue)/qcTime * 60));
	}

	public void setQcRate(double qcRate) {
	}

	public String getOperater() {
		return operater;
	}

	public void setOperater(String operater) {
		this.operater = operater;
	}

	public String getQcdate() {
		String pattern="HH:mm:ss";
		   SimpleDateFormat sdf= new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public void setQcdate(String qcdate) {
	}

	@Override
	public String toString() {
		return "QcRecord [id=" + this.getId() + ", preValue=" + this.getPreValue() + ", afterValue=" + this.getAfterValue() + ", qcTime=" + this.getQcTime()
				+ ", operater=" + this.getOperater() + ", workTime=" + this.getWorkTime() + "]";
	}
}
