package com.xx.test.mt.controller.ip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xx.test.mt.model.IP;
import com.xx.test.mt.service.ip.IIPService;

@Controller
@RequestMapping("/ip")
public class IPController {
	
	private IIPService ipService;
	
	@Autowired
	public void setIpService(IIPService ipService) {
		this.ipService = ipService;
	}

	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String getIPById(@RequestParam("ipId") Integer ipId,Model model){
		System.out.println("-->ipId:"+ipId);
		IP ip = ipService.getIPById(ipId);
		model.addAttribute("ip",ip);
		return "ip/ip_main";
	}
	
	@RequestMapping(value="/lst",method=RequestMethod.GET)
	public String getIPLst(Model model){
		List<IP> lst = ipService.getIPLstFromDB();
		model.addAttribute("lst",lst);
		return "ip";
	}
}
