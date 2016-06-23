package com.xx.test.mt.controller.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.test.mt.service.manage.IManageService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private IManageService manageService;
	@Autowired
	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}

	/**
	 * show tile main page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String showMain(Model model){
		System.out.println("in method showMain");
		return "main";
	}
	
	/**
	 * show about page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String showAbout(Model model){
		System.out.println("in method showAbout test maven auto update");
		return "about";
	}
	
	@RequestMapping(value="/menu",method=RequestMethod.POST)
	public String loadMenu(){
		
		return "menu";
	}
	
	/**
	 * load menu data list from database
	 * 
	 * @return json of list map
	 */
	@RequestMapping(value="/loadMenuData",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String,Object>> getMenuData(){
		List<Map<String,Object>> lstMenu = new ArrayList<Map<String,Object>>();
		lstMenu = manageService.getMenuLst();
		return lstMenu;
	}
}
