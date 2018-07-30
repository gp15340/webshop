package com.webshop.dao;

import com.webshop.bean.Admin;
import com.webshop.bean.User;

public interface AdminDao {
	public Admin selectAdmin(Admin admin);
	public boolean insert(Admin admin);
	public boolean update(Admin admin);
	public boolean delete(Integer id);
	
}
