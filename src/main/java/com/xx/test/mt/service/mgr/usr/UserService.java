package com.xx.test.mt.service.mgr.usr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.test.mt.dao.mybatis.UserInfoMapper;
import com.xx.test.mt.model.UserInfo;

@Service("userService")
public class UserService implements IUserService{
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}


	public List<UserInfo> getUserLst() {
		List<UserInfo> userLst = new ArrayList<UserInfo>();
		userLst = userInfoMapper.selectUserList();
		return userLst;
	}

}
