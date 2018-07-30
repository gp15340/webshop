package com.webshop.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.bean.Admin;
import com.webshop.service.AdminService;

@Controller
public class AdminAction {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/adminRegister")
	public String adminRegister(Model model,Admin admin) {
		boolean result = adminService.register(admin);
		if(result) {
			return "redirect:/adminLogin";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "AdminRegister";
		}
		
		
	}
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpSession session,Model model,Admin admin) {
		Admin ad=adminService.login(admin);
		if(ad!=null) {
			session.setAttribute("admin", ad);
			return "adminLoginSuccess";
		}else {
			model.addAttribute("errormsg", "登录失败");
			return "Register";
		}
		
		
	}
}
