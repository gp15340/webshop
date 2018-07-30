package com.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.bean.Address;
import com.webshop.bean.Order;
import com.webshop.bean.OrderDetail;
import com.webshop.bean.Orders;
import com.webshop.bean.Page;
import com.webshop.bean.Shopping;
import com.webshop.bean.User;
import com.webshop.dao.AddressDao;
import com.webshop.dao.OrderDao;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private AddressDao addressDao;
	
	public boolean insert(List<Shopping> shoppinglist,int addressId,User user,String orderTime) {
		Address address=addressDao.seleceById(addressId);
		for(Shopping shopping:shoppinglist) {
			Orders order=new Orders();
			order.setAddress(address);
			order.setUser(user);
			order.setOrderTime(orderTime);
			order.setOrderStatus("待付款");
			boolean flag=orderDao.insert(order);
			if(flag) {
				OrderDetail orderDetail =new OrderDetail();
				orderDetail.setOrders(order);
				orderDetail.setBookId(shopping.getBookId());
				orderDetail.setBookName(shopping.getBookName());
				orderDetail.setBookPrice(shopping.getBookPrice());
				orderDetail.setNumber(shopping.getNumber());
				orderDetail.setTotal();
				orderDao.insert(orderDetail);
				
			}
		}
		return true;
	}
	public List<Order> select(User user) {
		// TODO Auto-generated method stub
		List<Orders> orderslist=orderDao.selectOrders(user);
		List<Order> orderlist=new ArrayList<Order>();
		for(Orders orders:orderslist) {
			OrderDetail orderDetail =orderDao.selectOrderDetail(orders.getOrderId());
			Order order=new Order();
			order.setAddress(orders.getAddress());
			order.setOrderId(orders.getOrderId());
			order.setOrderTime(orders.getOrderTime());
			order.setOrderStatus(orders.getOrderStatus());
			order.setBookId(orderDetail.getBookId());
			order.setBookName(orderDetail.getBookName());
			order.setNumber(orderDetail.getNumber());
			order.setBookPrice(orderDetail.getBookPrice());
			order.setTotal(orderDetail.getTotal());
			order.setOrderTime(orders.getOrderTime());
			orderlist.add(order);
		}
		
		return orderlist;
		
	}
	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.delete(orderId);
		
	}
	public boolean payOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.updateToPay(orderId);
		
	}
	public boolean sendOrder(int orderId) {
		return orderDao.updateToSend(orderId);
	}
	
	public boolean receiveOrder(int orderId) {
		return orderDao.updateToReceive(orderId);
	}
	public List<Order> selectAllOrder(Page page) {
		// TODO Auto-generated method stub
		List<Orders> orderslist=orderDao.selectAllOrders(page);
		List<Order> orderlist=new ArrayList<Order>();
		for(Orders orders:orderslist) {
			OrderDetail orderDetail =orderDao.selectOrderDetail(orders.getOrderId());
			Order order=new Order();
			order.setUser(orders.getUser());
			order.setAddress(orders.getAddress());
			order.setOrderId(orders.getOrderId());
			order.setOrderTime(orders.getOrderTime());
			order.setOrderStatus(orders.getOrderStatus());
			order.setBookId(orderDetail.getBookId());
			order.setBookName(orderDetail.getBookName());
			order.setNumber(orderDetail.getNumber());
			order.setBookPrice(orderDetail.getBookPrice());
			order.setTotal(orderDetail.getTotal());
			order.setOrderTime(orders.getOrderTime());
			orderlist.add(order);
		}
		
		return orderlist;
	}
	public Long getCount() {
		// TODO Auto-generated method stub
		return orderDao.selectCount();
	}
	public List<Order> selectOrderById(Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	public Order selectOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		Orders orders=orderDao.selectById(orderId);
		OrderDetail orderDetail =orderDao.selectOrderDetail(orderId);
		Order order=new Order();
		order.setUser(orders.getUser());
		order.setAddress(orders.getAddress());
		order.setOrderId(orders.getOrderId());
		order.setOrderTime(orders.getOrderTime());
		order.setOrderStatus(orders.getOrderStatus());
		order.setBookId(orderDetail.getBookId());
		order.setBookName(orderDetail.getBookName());
		order.setNumber(orderDetail.getNumber());
		order.setBookPrice(orderDetail.getBookPrice());
		order.setTotal(orderDetail.getTotal());
		order.setOrderTime(orders.getOrderTime());
		return order;
	}
	
	
	
}
