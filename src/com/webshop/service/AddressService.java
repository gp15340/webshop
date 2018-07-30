package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.bean.Address;
import com.webshop.bean.User;
import com.webshop.dao.AddressDao;
@Service
@Transactional
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	public List<Address> select(User user) {
		// TODO Auto-generated method stub
		List<Address> addresslist=addressDao.select(user);
		return addresslist;
	}
	public boolean insert(User user, Address address) {
		// TODO Auto-generated method stub
		address.setUser(user);
		return addressDao.insert(address);
		
		
	}

}
