package com.hengtiansoft.jia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hengtiansoft.jia.dao.AdminDao;
import com.hengtiansoft.jia.entity.Admin;
@Repository("adminManager")
public class AdminManagerImpl implements AdminManager {
	@Autowired
	private AdminDao adminDao;
	public void setStudentDao(AdminDao adminDao){
		this.adminDao = adminDao;
	}
	
	/*
	 * 根据用户名和密码判断用户是否存在
	 * */
	@Override
	public Admin isExist(String name, String pwd) {
		return adminDao.isExist(name, pwd);
		
	}
}
