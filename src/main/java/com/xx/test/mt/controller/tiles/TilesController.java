package com.xx.test.mt.controller.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tilesShow")
public class TilesController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showTilesMain(Model model){
		System.out.print("in method showTilesMain");
		return "main";
	}
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String showAbout(Model model){
		System.out.print("in method showTilesMain");
		return "about";
	}
}
