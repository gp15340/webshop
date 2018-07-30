package com.webshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.bean.Admin;
@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Admin selectAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin where adminName=?and adminPassword=?");
		query.setParameter(0, admin.getAdminName());
		query.setParameter(1, admin.getAdminPassword());
		Admin adm=(Admin)query.uniqueResult();
		return adm;
	}

	@Override
	public boolean insert(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);
		return true;
	}

	@Override
	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Admin set adminName=?,adminPassword=?where adminId=?");
		query.setParameter(0, admin.getAdminName());
		query.setParameter(1, admin.getAdminPassword());
		query.setParameter(2, admin.getAdminId());
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
