package com.webshop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.bean.Book;
import com.webshop.bean.Page;
import com.webshop.bean.Paging;
import com.webshop.bean.Shopping;
import com.webshop.bean.User;
import com.webshop.service.BookService;
import com.webshop.service.CartService;
@Controller
public class CartAction {
	@Autowired
	private CartService cartService;
	@Autowired
	private BookService bookService;
	@RequestMapping("/addToCart")
	public String addToCart(Model model,Integer bookId,Integer number,Double total,HttpSession session) {
		
		User user=(User)session.getAttribute("user");
		if(user!=null) {
		boolean flag=cartService.insert(user,bookId,number,total);
		return "redirect:/showCart.do";
		}else {
			return "userLogin";
		}
	}
	@RequestMapping("/showCart")
	public String showCart(Model model,HttpSession session,Integer pageS,@ModelAttribute("errmsg")String errmsg){
		model.addAttribute("errmsg", errmsg);
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			Long totalCount =cartService.getCount(user);
			Paging paging = new Paging();
			Page page = paging.checkByPage(totalCount, pageS);
			//设置每页显示的条数
			page.setPagecount(5);
			page.setTotalpage();
			List<Shopping> cartlist=cartService.select(user,page);
			model.addAttribute("page",page);
			model.addAttribute("cartlist",cartlist);
			return "shoppingCart";
			}else {
				return "userLogin";
			}
	}
	@RequestMapping("/selectCart")
	public String selectCart(Model model,int shoppingId,int bookId) {
			Shopping shopping=cartService.selectById(shoppingId);
			Book book= bookService.selectById(bookId);
			model.addAttribute("book", book);
			model.addAttribute("shopping",shopping);
			return "updateCart";
	}
	
	
	@RequestMapping("/deleteCart")
	public String deleteCart(int shoppingId) {
		
		cartService.delete(shoppingId);
		
		return "redirect:/showCart.do";
	}
	@RequestMapping("/updateCart")
	public String updateCart(HttpSession session,int bookId,int number,double total) {
		User user=(User)session.getAttribute("user");
		cartService.update(user, bookId, number, total);
		return "redirect:/showCart.do";
	}
	@RequestMapping("/deleteCarts")
	public String deleteCarts(String[]orderlist,Model model) {
		if(orderlist==null) {
			model.addAttribute("errmsg", "请选择删除的对象");
			return "redirect:/showCart.do?errmsg=errmsg";
		}
		List<Shopping> shoppinglist=new ArrayList<Shopping>();
		for(int i=0;i<orderlist.length;i++) {
			String str=orderlist[i];
			String[]strs=str.split(";");
			int a=Integer.parseInt(strs[1]);
			cartService.delete(a);
		}
		
		return "redirect:/showCart.do";
	}
}
