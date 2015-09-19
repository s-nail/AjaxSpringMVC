package com.hengtiansoft.jia.dao;

import com.hengtiansoft.jia.entity.Admin;

public interface AdminDao {
	public Admin isExist(String name,String pwd);
}
