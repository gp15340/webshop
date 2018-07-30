package com.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.bean.Book;
import com.webshop.bean.Page;
import com.webshop.bean.Shopping;
import com.webshop.bean.ShoppingCart;
import com.webshop.bean.User;
import com.webshop.dao.BookDao;
import com.webshop.dao.CartDao;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private BookDao bookDao;
	public List<Shopping> select(User user,Page page){
		ShoppingCart cart=cartDao.selectCart(user);
		if(cart!=null) {
			List<Shopping> shoppinglist=cartDao.selectShopping(cart,page);
			return shoppinglist;
			
		}else {
			return null;
		}
	}
	public boolean insert(User user,int bookId,int number,double total) {
		
		boolean flag=false;
		ShoppingCart cart=cartDao.selectCart(user);
		if(cart==null) {
			cart=new ShoppingCart();
			cart.setUser(user);
			cartDao.add(cart);
		}
		Shopping exist=cartDao.getShopping(cart.getCartId(),bookId);
		//判断用户购物车是否已经存在该商品
		if(exist!=null) {
			exist.setNumber(number+exist.getNumber());
			exist.setTotal(total+exist.getTotal());
			flag=cartDao.update(exist);
		}else {
		Shopping shopping=new Shopping();
		shopping.setBookId(bookId);
		Book book=new Book();
		book=bookDao.selectById(bookId);
		shopping.setBookName(book.getBookName());
		shopping.setBookPrice(book.getBookPrice());
		shopping.setBookImgUrl(book.getImgUrl());
		shopping.setNumber(number);
		shopping.setTotal(total);
		shopping.setCart(cart);
		flag=cartDao.insert(shopping);
		}
		return flag;
	}
	
	public boolean update(User user,int bookId,int number,double total) {
		ShoppingCart cart=cartDao.selectCart(user);
		Shopping exist=cartDao.getShopping(cart.getCartId(),bookId);
		exist.setNumber(number);
		exist.setTotal(total);
		return cartDao.update(exist);
	}
	
	public boolean delete(int shoppingId) {
		
		return cartDao.delete(shoppingId);
	}
	
	
	public Shopping selectById(int shoppingId) {
		return cartDao.selectById(shoppingId);
	}
	public Long getCount(User user) {
		// TODO Auto-generated method stub
		ShoppingCart cart=cartDao.selectCart(user);
		if(cart!=null) {
			return cartDao.selectShoppingCount(cart);
			
		}else {
			Long l = new Long((long)0);
			return l;
		}
	}
	
	
}
