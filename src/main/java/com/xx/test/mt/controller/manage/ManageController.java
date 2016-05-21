package com.xx.test.mt.controller.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/**
	 * 初始化菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value={"getMenuLst"},method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getMenuLst(){
		List<Map<String, Object>> menuLst = service.getMenuLst();
		return menuLst;
	}
	
	/**
	 * add new menu
	 * 
	 * @param menuInfo
	 * @return
	 */
	@RequestMapping(value={"/addMenu"})
	@ResponseBody
	public Map<String, Object> addMenu(@ModelAttribute("menuInfo") MenuInfo menuInfo){
		Map<String, Object> retMap = new HashMap<String,Object>();
		System.out.println("enter in method addMenu,menu:"+menuInfo);
		retMap = service.addNewMenu(menuInfo);
		System.out.println("retMap==>"+JSON.toJSONString(retMap));
		return retMap;
	}
}
