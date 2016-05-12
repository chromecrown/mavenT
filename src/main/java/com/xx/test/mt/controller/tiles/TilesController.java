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
		System.out.println("enter in method getMenuData");
		List<Object> lstMenu = new ArrayList<Object>();
		
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("id",1);
		a.put("pId",0);
		a.put("name","root");
		a.put("open",true);
		a.put("isParent",true);
		lstMenu.add(a);
		
		Map<String,Object> b = new HashMap<String,Object>();
		b.put("id",11);
		b.put("pId",1);
		b.put("name","Leaf1");
		b.put("open",true);
		b.put("isParent",false);
		lstMenu.add(b);
		
		Map<String,Object> c = new HashMap<String,Object>();
		c.put("id",2);
		c.put("pId",0);
		c.put("name","乐视");
		c.put("open",true);
		c.put("isParent",true);
		c.put("url","http://www.le.com");
		c.put("target","_blank");
		lstMenu.add(c);
		
		Map<String,Object> d = new HashMap<String,Object>();
		d.put("id",3);
		d.put("pId",0);
		d.put("name","腾讯");
		d.put("open",true);
		d.put("isParent",true);
		d.put("url","http://www.qq.com");
		d.put("target","_blank");
		lstMenu.add(d);
		
		System.out.println("will leave method getMenuData");
		return lstMenu;
	}
}
