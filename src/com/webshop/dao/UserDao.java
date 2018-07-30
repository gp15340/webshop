package com.webshop.dao;

import java.util.List;

import com.webshop.bean.Page;
import com.webshop.bean.User;

public interface UserDao {
	public User selectUser(User user);
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(Integer id);
	public List<User> selectAllUser(Page page);
	public User selectById(Integer id);
	public Long getUserCount();
	public boolean checkUser(String userName);
}
