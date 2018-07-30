package com.webshop.dao;

import java.util.List;

import com.webshop.bean.OrderDetail;
import com.webshop.bean.Orders;
import com.webshop.bean.Page;
import com.webshop.bean.User;

public interface OrderDao {
	public OrderDetail selectOrderDetail(int orderId);
	public List<Orders> selectOrders(User user);
	public boolean insert(Orders order);
	public boolean insert(OrderDetail orderDetail);
	public boolean update(Orders order);
	public boolean update(OrderDetail orderDetail);
	public boolean delete(int orderId);
	public Orders selectById(int orderId);
	public boolean updateToPay(int orderId);
	public boolean updateToSend(int orderId);
	public boolean updateToReceive(int orderId);
	public List<Orders> selectAllOrders(Page page);
	public Long selectCount();
}
