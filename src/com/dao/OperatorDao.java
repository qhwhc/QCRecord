package com.dao;

public interface OperatorDao {
	public void save(String FilePath,String names);
	public String[] getList(String FilePath);
	public boolean delete(String filePath,String name);
}
