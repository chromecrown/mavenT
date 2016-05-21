package com.xx.test.mt.service.manage;

import org.springframework.stereotype.Service;

import com.xx.test.mt.model.MenuInfo;

@Service("manageService")
public interface IManageService {
	
	/**
	 * 获取新增菜单id
	 * 生成规则为最大条数加一
	 * 
	 * @return
	 */
	public int getNewMenuCode();
	
	/**
	 * 新增菜单
	 * 
	 * @param menuInfo
	 * @return  新增的菜单实例对象
	 */
	public MenuInfo addNewMenu(MenuInfo menuInfo);
}
