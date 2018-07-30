package com.webshop.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.bean.Page;
import com.webshop.bean.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean insert(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update User set userName=?,password=?,email=?,avatarUrl=?where userId=?");
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		query.setString(2, user.getEmail());
		query.setParameter(3, user.getAvatarUrl());
		query.setInteger(4, user.getUserId());
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean delete(Integer userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from User where userId=?");
		query.setParameter(0, userId);
		query.executeUpdate();
		return true;
	}

	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where userName=?and password=? ");
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		
		User u=(User)query.uniqueResult();
		return u;
		
	}

	@Override
	public List<User> selectAllUser(Page page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from User order by userId asc");
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<User> userlist= query.list();
		return userlist;
	}

	@Override
	public User selectById(Integer userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where userId=? ");
		query.setParameter(0, userId);
		User u=(User)query.uniqueResult();
		return u;
	}

	@Override
	public Long getUserCount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("select count(*)from User");
		Long count=(Long)query.uniqueResult();
		return count;
	}

	@Override
	public boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where userName=? ");
		query.setParameter(0, userName);
		User u=(User)query.uniqueResult();
		if(u!=null) {
			return true;
		}else {
			return false;
		}
		
	}

	

}
