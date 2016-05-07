package com.xx.test.mt.controller.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tilesShow")
public class TilesController {
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String getIPById(Model model){
		
		return "main";
	}
}
