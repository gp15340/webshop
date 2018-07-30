package com.webshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webshop.bean.Page;
import com.webshop.bean.Shopping;
import com.webshop.bean.ShoppingCart;
import com.webshop.bean.User;
@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public ShoppingCart selectCart(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from ShoppingCart where user=?");
		query.setParameter(0, user);
		ShoppingCart cart=(ShoppingCart)query.uniqueResult();
		return cart;
	}

	@Override
	public List<Shopping> selectShopping(ShoppingCart cart,Page page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Shopping where cart=? order by shoppingId asc");
		query.setParameter(0, cart);
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<Shopping> shoppinglist=query.list();
		return shoppinglist;
	}

	@Override
	public boolean insert(Shopping shopping) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(shopping);
		return true;
	}

	@Override
	public boolean add(ShoppingCart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(cart);
		return true;
	}

	@Override
	public Shopping selectById(int shoppingId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Shopping where shoppingId=?");
		query.setParameter(0, shoppingId);
		Shopping shopping =(Shopping)query.uniqueResult();
		return shopping;
	}

	@Override
	public boolean update(Shopping shopping) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Shopping set number=?,total=? where bookId=?and cartId=?");
		query.setParameter(0,shopping.getNumber());
		query.setParameter(1, shopping.getTotal());
		query.setParameter(2,shopping.getBookId());
		query.setParameter(3,shopping.getCart().getCartId());
		query.executeUpdate();
		return true;
	}

	@Override
	public Shopping getShopping(int cartId, int bookId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Shopping where cartId=?and bookId=?");
		query.setParameter(0, cartId);
		query.setParameter(1, bookId);
		Shopping shopping =(Shopping)query.uniqueResult();
		return shopping;
	}

	@Override
	public boolean delete(int shoppingId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Shopping where shoppingId=?");
		query.setParameter(0, shoppingId);
		query.executeUpdate();
		return true;
	}

	@Override
	public Long selectShoppingCount(ShoppingCart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("select count(*)from Shopping where cart=?");
		query.setParameter(0, cart);
		Long count=(Long)query.uniqueResult();
		return count;
	}

}
