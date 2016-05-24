package com.xx.test.mt.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	/**
	 * show login page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String showLogin(Model model){
		System.out.println("in method showLogin");
		return "login";
	}
	
	/**
	 * do login action
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value={"/dologin"})
	public String doLogin(String username,String password,HttpServletRequest request){
		System.out.println("username:" + username + " password:" + password);
		if(null!=username & !username.equals("")){
			HttpSession session = request.getSession();
			session.setAttribute("logined", true);
		}
		return "redirect:/";
	}
	
	/**
	 * logout
	 * 
	 * @return
	 */
	@RequestMapping(value={"logout"})
	public String logout(HttpServletRequest request){
		//do something of cleaning
		HttpSession session = request.getSession();
		session.removeAttribute("logined");
		return "redirect:/login";
	}
}
