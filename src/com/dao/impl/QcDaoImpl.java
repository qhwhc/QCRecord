package com.dao.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.common.util.FileUtil;
import com.dao.QcDao;
import com.pojo.QcRecord;

import net.sf.json.JSONArray;



public class QcDaoImpl implements QcDao {
	String pattern="yyyy_MM_dd";
	SimpleDateFormat sdf= new SimpleDateFormat(pattern);
	@Override
	public boolean add(QcRecord qcRecord) {
		/*创建文件夹*/
		try {
			String filepath = System.getProperty("user.dir") + "/record_data/" + sdf.format(new Date());
			File file = new File(filepath);
			JSONArray jsonArray = new JSONArray();
			if(!file.exists()) {
				file.createNewFile();
			}else {
				String str = FileUtil.readFile(filepath);
				if(str.indexOf("[") >= 0) {
					jsonArray = JSONArray.fromObject(str);
				}else {

				}
			}
			jsonArray.add(qcRecord);
			FileUtil.wirte(filepath, jsonArray.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public JSONArray get(String FilePath) {
		String info = FileUtil.readFile(FilePath);
		if(info.indexOf("[") >= 0) {
			return JSONArray.fromObject(info);
		}
		return null;
	}


}
