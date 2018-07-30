package com.webshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webshop.bean.OrderDetail;
import com.webshop.bean.Orders;
import com.webshop.bean.Page;
import com.webshop.bean.User;
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public OrderDetail selectOrderDetail(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from OrderDetail where orderId=?");
		query.setParameter(0, orderId);
		OrderDetail orderDetail=(OrderDetail)query.uniqueResult();
		return orderDetail;
	}

	@Override
	public List<Orders> selectOrders(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Orders where userId=?");
		query.setParameter(0, user.getUserId());
		List<Orders> orderlist=query.list();
		return orderlist;
	}

	@Override
	public boolean insert(Orders order) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(order);
		return true;
	}

	@Override
	public boolean insert(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(orderDetail);
		return true;
	}

	@Override
	public boolean update(Orders order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Orders set addressId=?,orderStatus=? where orderId=?");
		query.setParameter(0,order.getAddress().getAddressId());
		query.setParameter(1, order.getOrderStatus());
		query.setParameter(2,order.getOrderId());
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Orders where orderId=?");
		query.setParameter(0, orderId);
		query.executeUpdate();
		return true;
	}

	@Override
	public Orders selectById(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Orders where orderId=?");
		query.setParameter(0, orderId);
		Orders order =(Orders)query.uniqueResult();
		return order;
	}

	@Override
	public boolean updateToPay(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Orders set orderStatus=?where orderId=?");
		query.setParameter(0, "已付款");
		query.setParameter(1, orderId);
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean updateToSend(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Orders set orderStatus=?where orderId=?");
		query.setParameter(0, "已发货");
		query.setParameter(1, orderId);
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean updateToReceive(int orderId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Orders set orderStatus=?where orderId=?");
		query.setParameter(0, "已签收");
		query.setParameter(1, orderId);
		query.executeUpdate();
		return true;
	}

	@Override
	public List<Orders> selectAllOrders(Page page) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Orders order by userId asc");
		query.setFirstResult((page.getDpage()-1) * page.getPagecount());
		query.setMaxResults(page.getPagecount());
		List<Orders> orderlist=query.list();
		return orderlist;
	}

	@Override
	public Long selectCount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("select count(*)from Orders");
		Long count=(Long)query.uniqueResult();
		return count;
	}

}
