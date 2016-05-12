package com.xx.test.mt.controller.ip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * show information about ip
	 * @return
	 */
	@RequestMapping(value={"/",""})
	public String showIPPage(){
		System.out.println("enter method showIPPage=>");
		return "ip";
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String getIPById(@RequestParam("ipId") Integer ipId,Model model){
		System.out.println("-->ipId:"+ipId);
		IP ip = ipService.getIPById(ipId);
		model.addAttribute("ip",ip);
		return "ip/ip_main";
	}
	
	@RequestMapping(value="/lst",method=RequestMethod.POST)
	@ResponseBody
	public List<IP> getIPLst(Model model){
		List<IP> lst = ipService.getIPLstFromDB();
		model.addAttribute("lst",lst);
		System.out.println("lst:"+lst);
		return lst;
	}
	
	/**
	 * 分页查询IP数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/pageLst",method=RequestMethod.POST)
	@ResponseBody
	public List<IP> getIPPageLst(){
		Map<String,Object> arg = new HashMap<String,Object>();
		arg.put("start",0);
		arg.put("offset",5);
		List<IP> lst = ipService.getIPPageLst(arg);
		System.out.println("getIPPageLst:"+lst);
		return lst;
	}
}
