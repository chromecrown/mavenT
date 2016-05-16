package com.xx.test.mt.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	/**
	 * show manage page
	 * 
	 * @return
	 */
	@RequestMapping(value={"/",""})
	public String showManagePage(){
		System.out.println("enter method showIPPage=>");
		return "manage";
	}
}
