package com.xx.test.mt.controller.ip;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	 * get count
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cnt",method=RequestMethod.POST)
	@ResponseBody
	public int getCnt(HttpServletRequest request){
		int retVal = ipService.getIPCnt(request);
		System.out.println("getIPPageCnt:"+retVal);
		return retVal;
	}
	
	/**
	 * 分页查询数据
	 * 
	 * @return
	 */
	@RequestMapping(value="/pageLst",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getIPPageLst(HttpServletRequest request){
		Map<String,Object> retVal = ipService.getIPPageLst(request);
		System.out.println("class IPController,method getIPPageLst:"+retVal);
		return retVal;
	}
}
