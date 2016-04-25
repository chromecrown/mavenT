package com.xx.test.mt.service.mgr.usr;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xx.test.mt.model.UserInfo;

@Service("userService")
public interface IUserService {

	/**
	 * get all user list with belonging group info list
	 *  
	 * @return
	 */
	public List<UserInfo> getUserLst();
}
