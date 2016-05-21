package com.xx.test.mt.service.manage;

import java.util.List;
import java.util.Map;
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
	public Map<String, Object> addNewMenu(MenuInfo menuInfo);
	
	/**
	 * 获取所有的菜单列表
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMenuLst();
}
