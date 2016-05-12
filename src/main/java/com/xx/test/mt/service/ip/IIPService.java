package com.xx.test.mt.service.ip;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xx.test.mt.model.IP;

@Service("ipService")
public interface IIPService {
	
	public IP getIPById(Integer ipId);
	
	public List<IP> getIPLst();
	
	/**
	 * get list comprise by ip
	 * @return
	 */
	public List<IP> getIPLstFromDB();
	
	
	/**
	 * get ip data by page
	 * 
	 * @return
	 */
	public List<IP> getIPPageLst(Map arg);
}
