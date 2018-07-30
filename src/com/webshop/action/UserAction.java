package com.webshop.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.bean.Page;
import com.webshop.bean.Paging;
import com.webshop.bean.User;
import com.webshop.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@RequestMapping("/userRegister")
	public String userRegiser(Model model,User user) {
		//设置默认头像
		user.setAvatarUrl("Images/my.jpg");
		boolean result = userService.register(user);
		if(result) {
			return "userLogin";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "userRegister";
		}
		
	}
	
	@RequestMapping("/userLogin")
	public String userLogin(Model model,HttpSession session,User user) {
		User u=userService.login(user);
		if(u!=null) {
			session.setAttribute("user", u);
			return "redirect:/loadBookList.do";
		}else {
			model.addAttribute("errormsg", "登录失败");
			return "userRegister";
		}
	}
	
	@RequestMapping("/userDetail")
	public String userDetail(Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("user",user);
		return "userDetail";
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdate(HttpServletRequest request,Model model,User user,@RequestParam MultipartFile file) {
		String rootPath = request.getServletContext().getRealPath("/");
		try {
			FileCopyUtils.copy(file.getBytes(),new File(rootPath + "/Images",file.getOriginalFilename()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String realPath = "Images/" + file.getOriginalFilename();
		if(realPath.length()>7) {
		user.setAvatarUrl(realPath);
		}
		boolean result = userService.update(user);
		if(result) {
			return "userDetail";
		}else {
			model.addAttribute("errormsg", "修改失败");
			return "userDetail";
		}
	}
	@RequestMapping("/showAllUser")
	public String showAllUser(Model model,Integer pageS) {
		Long totalCount =userService.getCount();
		Paging paging = new Paging();
		Page page = paging.checkByPage(totalCount, pageS);
		List<User> userlist=userService.showAllUser(page);
		model.addAttribute("page",page);
		model.addAttribute("userlist", userlist);
		return "adminShowUser";
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer userId) {
		userService.delete(userId);
		return "redirect:showAllUser.do";
	}
	@RequestMapping("/adminUpdateUser")
	public String adminUpdateUser(Model model,Integer userId) {
		User user=userService.selectById(userId);
		model.addAttribute("user", user);
		return "adminUpdateUser";
	}
	@RequestMapping("/userUpdateByAdmin")
	public String userUpdateByAdmin(HttpServletRequest request,Model model,User user,@RequestParam MultipartFile file) {
		String rootPath = request.getServletContext().getRealPath("/");
		try {
			FileCopyUtils.copy(file.getBytes(),new File(rootPath + "/Images",file.getOriginalFilename()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String realPath = "Images/" + file.getOriginalFilename();
		if(realPath.length()>7) {
		user.setAvatarUrl(realPath);
		}
		boolean result = userService.update(user);
		if(result) {
			return "redirect:showAllUser.do";
		}else {
			model.addAttribute("errormsg", "修改失败");
			return "redirect:showAllUser.do";
		}
	}
	@RequestMapping("/checkUser")
	public void checkUser(String userName,HttpServletResponse response) {
		boolean flag = userService.checkUser(userName);
		if (flag) {
			try {
				response.getWriter().print("yes");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().print("no");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("/searchUserById")
	public String searchUserById(Integer userId,Model model) {
		User user=userService.selectById(userId);
		model.addAttribute("user", user);
		return "adminShowUserByUserId";
	}

}

