package com.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.bean.Admin;
import com.webshop.dao.AdminDao;

@Service
public class AdminService {
@Autowired
private AdminDao adminDao;

public boolean register(Admin admin) {
	// TODO Auto-generated method stub
	
		return adminDao.insert(admin);
	
}

public Admin login(Admin admin) {
	// TODO Auto-generated method stub
	return adminDao.selectAdmin(admin);
}
}
