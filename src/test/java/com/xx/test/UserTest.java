package com.xx.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.alibaba.fastjson.JSON;
import com.xx.test.mt.common.test.TestBase;
import com.xx.test.mt.model.UserInfo;
import com.xx.test.mt.service.mgr.usr.IUserService;

public class UserTest extends TestBase{
	
	private IUserService userService;
	
	@Autowired
	@Qualifier("userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Test
	public void testUserLst(){
		List<UserInfo> userLst = new ArrayList<UserInfo>();
		userLst = userService.getUserLst();
		System.out.println("getted user list :" + JSON.toJSONString(userLst));
		System.out.println("getted user list with WithDateFormat :" + JSON.toJSONStringWithDateFormat(userLst,"yyyy-MM-dd HH:mm:ss"));
	}
}
