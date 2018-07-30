package com.webshop.dao;

import java.util.List;

import com.webshop.bean.Address;
import com.webshop.bean.User;

public interface AddressDao {

	public List<Address> select(User user);

	public boolean insert(Address address);
	public Address seleceById(int addressId);
	
	
}
