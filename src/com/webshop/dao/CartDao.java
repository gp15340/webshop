package com.webshop.dao;

import java.util.List;

import com.webshop.bean.Page;
import com.webshop.bean.Shopping;
import com.webshop.bean.ShoppingCart;
import com.webshop.bean.User;

public interface CartDao {
	public ShoppingCart selectCart(User user);
	public List<Shopping> selectShopping(ShoppingCart cart,Page page);
	public boolean insert(Shopping shopping);
	public boolean update(Shopping shopping);
	public boolean delete(int shoppingId);
	public boolean add(ShoppingCart cart);
	public Shopping getShopping(int cartId,int bookId);
	public Shopping selectById(int shoppingId);
	public Long selectShoppingCount(ShoppingCart cart);
}
