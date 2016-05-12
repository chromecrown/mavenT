package com.xx.test.mt.controller.tiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TilesController {
	
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
	
	@RequestMapping(value="/loadMenuData",method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getMenuData(){
		List<Object> lstMenu = new ArrayList<Object>();
		
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("id",1);
		a.put("pId",0);
		a.put("name","root");
		a.put("open",true);
		lstMenu.add(a);
		
		Map<String,Object> b = new HashMap<String,Object>();
		b.put("id",11);
		b.put("pId",1);
		b.put("name","Leaf1");
		b.put("open",true);
		lstMenu.add(b);
		
		return lstMenu;
	}
}
