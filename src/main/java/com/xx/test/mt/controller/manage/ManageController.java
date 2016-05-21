package com.xx.test.mt.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xx.test.mt.model.MenuInfo;
import com.xx.test.mt.service.manage.IManageService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	IManageService service;
	
	@Autowired
	//@Qualifier("manageService")
	public void setService(IManageService service) {
		this.service = service;
	}

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
	
	@RequestMapping(value={"/addMenu"})
	@ResponseBody
	public MenuInfo addMenu(@ModelAttribute("menuInfo") MenuInfo menuInfo){
		System.out.println("enter in method addMenu,menu:"+menuInfo);
		menuInfo = service.addNewMenu(menuInfo);
		String menuStr = JSON.toJSONString(menuInfo);
		System.out.println("menuInfo==>"+menuStr);
		return menuInfo;
	}
}
