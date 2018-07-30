package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.bean.Page;
import com.webshop.bean.User;
import com.webshop.dao.UserDao;

@Service

public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user) {
		return userDao.insert(user);
	}
	public User login(User user) {
		return userDao.selectUser(user);
	}
	public boolean update(User user) {
		return userDao.update(user);
	}
	public List<User> showAllUser(Page page) {
		// TODO Auto-generated method stub
		return userDao.selectAllUser(page);
	}
	public boolean delete(Integer userId) {
		return userDao.delete(userId);
		
	}
	public User selectById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectById(userId);
	}
	public Long getCount() {
		// TODO Auto-generated method stub
		return userDao.getUserCount();
	}
	public boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkUser(userName);
	}

}
