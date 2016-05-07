package com.xx.test.mt.controller.tiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tilesShow")
public class TilesController {
	private static Logger log = LoggerFactory.getLogger(TilesController.class);
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String getIPById(Model model){
		
		return "ip/ip_main";
	}
}
