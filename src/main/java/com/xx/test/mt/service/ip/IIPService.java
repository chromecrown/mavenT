package com.xx.test.mt.service.ip;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xx.test.mt.model.IP;

@Service("ipService")
public interface IIPService {
	
	public IP getIPById(Integer ipId);
	
	public List<IP> getIPLst();
	
	public List<IP> getIPLstFromDB();
}
