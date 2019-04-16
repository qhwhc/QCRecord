package com.dao.impl;

import com.common.util.FileUtil;
import com.dao.OperatorDao;

public class OperatorDaoImpl implements OperatorDao {

	@Override
	public String[] getList(String FilePath) {
		return FileUtil.readFile(FilePath).split(",");
	}

	@Override
	public boolean delete(String filePath,String name) {
		boolean isExist = false;
		int index = -1;
		String[] strings = FileUtil.readFile(filePath).split(",");
		for (int i = 0; i < strings.length; i++) {
			if(name.equals(strings[i])) {
				isExist = true;
				index = i;
				break;
			}
		}
		StringBuilder str = new StringBuilder();
		if(isExist) {
			for (int i = 0; i < strings.length; i++) {
				if(i != index) {
					str.append("," + strings[i]) ;
				}
			}
			save(System.getProperty("user.dir") + "/record_data/operator",str.toString());
		}
		return isExist;
	}

	@Override
	public void save(String FilePath,String names) {
		if(names.startsWith(",")) {
			names = names.substring(1, names.length());
		}
		System.out.println(names);
		FileUtil.wirte(FilePath, names);
	}
	
}
