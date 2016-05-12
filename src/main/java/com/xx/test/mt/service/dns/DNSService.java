package com.xx.test.mt.service.dns;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("DnsService")
public class DNSService implements IDnsService {
	public List<String> getAllDNS() {
		List<String> list = new ArrayList<String>();
		list.add("baidu.com");
		list.add("google.com");
		list.add("le.com");
		list.add("51cto.com");
		list.add("csdn.com");
		return list;
	}

}
