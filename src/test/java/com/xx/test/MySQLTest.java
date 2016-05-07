package com.xx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.xx.test.mt.common.test.TestBase;
import com.xx.test.mt.model.IP;
import com.xx.test.mt.service.dns.IDnsService;
import com.xx.test.mt.service.ip.IIPService;

public class MySQLTest extends TestBase{
	
	private IDnsService dnsService;
	private IIPService ipService;
	
	@Autowired
	public void setIpService(IIPService ipService) {
		this.ipService = ipService;
	}

	@Autowired
	public void setDnsService(IDnsService dnsService) {
		this.dnsService = dnsService;
	}
	
	/**
	 * get all IP list 
	 */
	@Test
	public void testGetIPList(){
		List<IP> lst = new ArrayList<IP>();
		lst = ipService.getIPLst();
		logger.info("==>ip list:"+JSON.toJSONString(lst));
	}
	
	/**
	 * test get list of ip from mysql
	 */
	@Test
	public void testGetLstFromDB(){
		List<IP> lst = new ArrayList<IP>();
		lst = ipService.getIPLstFromDB();
		System.out.println("test method testGetLstFromDB==>ip list:"+JSON.toJSONString(lst));
	}
	
	/**
	 * get all dns list
	 */
	@Test
	public void testGetDNSList(){
		List<String> lst = new ArrayList<String>();
		lst = dnsService.getAllDNS();
		System.out.println("==>dns list:");
		System.out.println(JSON.toJSONString(lst));
	}
}
