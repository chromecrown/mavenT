package com.xx.test.mt.controller.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
