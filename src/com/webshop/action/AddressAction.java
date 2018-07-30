package com.webshop.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.bean.Address;
import com.webshop.bean.User;
import com.webshop.service.AddressService;

@Controller
public class AddressAction {
	@Autowired
	private AddressService addressService;
	@RequestMapping("/findAddress")
	public String findAddress(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		List<Address> addresslist=addressService.select(user);
		model.addAttribute("addresslist", addresslist);
		return "orderAddress";
	}
	@RequestMapping("/addAddress")
	public String addAddress(Address address,HttpSession session) {
		User user=(User)session.getAttribute("user");
		addressService.insert(user,address);
		return "redirect:/findAddress.do";
	}
	

}
