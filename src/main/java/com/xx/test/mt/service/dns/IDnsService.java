package com.xx.test.mt.service.dns;

import java.util.List;

import org.springframework.stereotype.Service;


@Service("dnsService")
public interface IDnsService {
	
	/**
	 * get all domain
	 * 
	 * @return domain list
	 */
	public List<String> getAllDNS();
}
