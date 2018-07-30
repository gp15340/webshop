package com.webshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webshop.bean.Address;
import com.webshop.bean.Book;
import com.webshop.bean.User;
@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Address> select(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Address where user=?");
		query.setParameter(0, user);
		List<Address> addresslist=query.list();
		return addresslist;
	}
	@Override
	public boolean insert(Address address) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
		return true;
		
	}
	@Override
	public Address seleceById(int addressId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Address where addressId=?");
		query.setInteger(0, addressId);
		Address address=(Address)query.uniqueResult();
		return address;
	}

}
