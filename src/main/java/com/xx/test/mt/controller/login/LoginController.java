package com.xx.test.mt.controller.login;

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
	public String doLogin(String username,String password){
		System.out.println("username:" + username + " password:" + password);
//		return "main";
		return "redirect:/";
	}
	
	/**
	 * logout
	 * 
	 * @return
	 */
	@RequestMapping(value={"logout"})
	public String logout(){
		//do something of cleaning
		return "redirect:/login";
	}
}
