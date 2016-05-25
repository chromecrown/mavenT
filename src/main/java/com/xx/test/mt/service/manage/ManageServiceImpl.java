package com.xx.test.mt.service.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> addNewMenu(MenuInfo menuInfo) {
		Map<String,Object> retObj = new HashMap<String,Object>();
		int isExist = menuInfoMapper.selectByMenuHref(menuInfo);//根据名称和href查询记录数量 判断是否已经存在
		if(isExist >= 1){
			//已经存在
			retObj.put("code", 1);
		}else{
			int newMenuCode = getNewMenuCode();//获取所有菜单记录数量
			menuInfo.setMenucode(newMenuCode);
			int effectedCnt = menuInfoMapper.insertSelective(menuInfo);
			if(effectedCnt == 1){
				//add success
				retObj.put("code", 0);
				retObj.put("obj", menuInfo);
			}else if(effectedCnt == 0){
				//add failed
				retObj.put("code", -1);
			}
		}
		return retObj;
	}

	@Override
	public List<Map<String, Object>> getMenuLst() {
		List<MenuInfo> menuLst = menuInfoMapper.selectMenuLst();
		List<Map<String, Object>> lst = new ArrayList<Map<String,Object>>();
		int len = menuLst.size();
		for(int i=0;i < len ;i++){
			Map<String, Object> map = new HashMap<String,Object>();
			MenuInfo obj = menuLst.get(i);
			map.put("id", obj.getMenucode());
			map.put("pId", obj.getParentcode());
			map.put("name", obj.getMenuname());
			map.put("url", obj.getMenuhref());
			lst.add(map);
		}
		return lst;
	}
	
	
}
