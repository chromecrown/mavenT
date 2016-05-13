package com.xx.test.mt.service.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.test.mt.dao.mybatis.IPMapper;
import com.xx.test.mt.model.IP;

@Service("ipService")
public class IPServiceImpl implements IIPService{
	
	private IPMapper ipMapper;
	
	@Autowired
	public void setIpMapper(IPMapper ipMapper) {
		this.ipMapper = ipMapper;
	}

	public IP getIPById(Integer ipId) {
		IP ipObj = new IP();
		ipObj.setIp("1.2.3.4");
		ipObj.setId(1);
		ipObj.setInOut("out");
		return ipObj;
	}
	
	public List<IP> getIPLst(){
		List<IP> ipLst = new ArrayList<IP>();
		for(int i = 0;i<10; i++){
			IP obj = new IP();
			obj.setId(i);
			obj.setInOut("in");
			obj.setIp("10.1.1."+String.valueOf(i));
			ipLst.add(obj);
		}
		
		return ipLst;
	}
	
	public List<IP> getIPLstFromDB(){
		List<IP> ipLst = new ArrayList<IP>();
		ipLst = ipMapper.getIPLst();
		return ipLst;
	}
	
	public Map<String,Object> getIPPageLst(HttpServletRequest request){
		Map<String,Object> retVal = new HashMap<String,Object>();
		
		List<IP> ipLst = new ArrayList<IP>();
		Map<String,Object> arg = new HashMap<String,Object>();
		
		//Map<String,String[]> parameterMap = request.getParameterMap();
		String sEcho = request.getParameter("sEcho");
		String iDisplayStart = request.getParameter("iDisplayStart");
		String iDisplayLength = request.getParameter("iDisplayLength");
		String iSortCol_0 = request.getParameter("iSortCol_0");
		String sSortDir_0 = request.getParameter("sSortDir_0");
		
		int cnt = ipMapper.getIPCnt(arg);//call dao get count
		ipLst = ipMapper.getIPPageLst(arg);//call dao get data list
		
		retVal.put("sEcho",sEcho);
		retVal.put("iTotalRecords",0);
		
		return retVal;
	}
}
