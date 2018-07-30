package com.webshop.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.bean.Book;
import com.webshop.bean.Order;
import com.webshop.bean.Page;
import com.webshop.bean.Paging;
import com.webshop.bean.Shopping;
import com.webshop.bean.User;
import com.webshop.service.CartService;
import com.webshop.service.OrderService;

@Controller
public class OrderAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addToOrder")
	public String addToOrder(Model model,HttpSession session,String[]orderlist) {
		if(orderlist==null) {
			model.addAttribute("errmsg", "请选择提交的对象");
			return "redirect:/showCart.do?errmsg=errmsg";
		}
		List<Shopping> shoppinglist=new ArrayList<Shopping>();
		for(int i=0;i<orderlist.length;i++) {
			String str=orderlist[i];
			String[]strs=str.split(";");
			int a=Integer.parseInt(strs[1]);
			shoppinglist.add(cartService.selectById(a));
		}
		session.setAttribute("shoppinglist",shoppinglist);
		
		return "redirect:/findAddress.do";
	}
	@RequestMapping("/insertToOrder")
	public String insertToOrder(HttpSession session,Integer addressId) {
		User user =(User)session.getAttribute("user");
		List<Shopping> shoppinglist=(List<Shopping>)session.getAttribute("shoppinglist");
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String orderTime=df.format(day);
		boolean flag=orderService.insert(shoppinglist,addressId,user,orderTime);
		
		return "redirect:/showOrders.do";
	}
	@RequestMapping("/showOrders")
	public String showOrders(HttpSession session,Model model) {
		User user =(User)session.getAttribute("user");
		List<Order> orderlist=orderService.select(user);
		model.addAttribute("orderlist", orderlist);
		return "userOrders";
	}
	@RequestMapping("/deleteOrder")
	public String deleteOrder(int orderId) {
		orderService.delete(orderId);
		return "redirect:/showOrders.do";
	}
	@RequestMapping("/adminDeleteOrder")
	public String adminDeleteOrder(int orderId) {
		orderService.delete(orderId);
		return "redirect:/showAllOrder.do";
	}
	
	@RequestMapping("/payOrder")
	public String payOrder(int orderId) {
		orderService.payOrder(orderId);
		return "redirect:/showOrders.do";
	}
	@RequestMapping("/sendOrder")
	public String sendOrder(int orderId) {
		orderService.sendOrder(orderId);
		return "redirect:/showOrders.do";
	}
	@RequestMapping("/adminSendOrder")
	public String adminSendOrder(int orderId) {
		orderService.sendOrder(orderId);
		return "redirect:/showAllOrder.do";
	}
	@RequestMapping("/receiveOrder")
	public String receiveOrder(int orderId) {
		orderService.receiveOrder(orderId);
		return "redirect:/showOrders.do";
	}
	@RequestMapping("/adminReceiveOrder")
	public String adminReceiveOrder(int orderId) {
		orderService.receiveOrder(orderId);
		return "redirect:/showAllOrder.do";
	}
	@RequestMapping("/showAllOrder")
	public String showAllOrder(Model model,Integer pageS) {
		Long totalCount =orderService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		List<Order> orderlist=orderService.selectAllOrder(page);
		model.addAttribute("page",page);
		model.addAttribute("orderlist", orderlist);
		return "adminShowOrder";
	}
	@RequestMapping("/searchOrderById")
	public String searchOrderById(Model model,Integer orderId) {
		
		Order order=orderService.selectOrderById(orderId);
		
		
		model.addAttribute("order", order);
		return "adminShowOrderByOrderId";
	}
	
}
