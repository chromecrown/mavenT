package com.xx.test.mt.service.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.test.mt.dao.mybatis.MenuInfoMapper;
import com.xx.test.mt.model.MenuInfo;

@Service
public class ManageServiceImpl implements IManageService{

	private MenuInfoMapper menuInfoMapper;
	
	@Autowired
	public void setMenuInfoMapper(MenuInfoMapper menuInfoMapper) {
		this.menuInfoMapper = menuInfoMapper;
	}

	@Override
	public int getNewMenuCode() {
		int cnt = menuInfoMapper.selectCount();
		int menuId = cnt + 1;
		return menuId;
	}

	@Override
	public MenuInfo addNewMenu(MenuInfo menuInfo) {
		int newMenuCode = getNewMenuCode();
		menuInfo.setMenucode(newMenuCode);
		
		return menuInfo;
	}
	
	
}
