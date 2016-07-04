package com.xx.test.mt.dao.mybatis;

import java.util.List;
import com.xx.test.mt.model.MenuInfo;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo menuInfo);

    int insertSelective(MenuInfo menuInfo);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuInfo menuInfo);
    
    int updateByMenuCodeSelective(MenuInfo menuInfo);

    int updateByPrimaryKey(MenuInfo menuInfo);
    
    int selectCount();
    
    int selectByMenuHref(MenuInfo menuInfo);
    
    /**
     * 所有菜单列表
     * 
     * @return
     */
    List<MenuInfo> selectMenuLst();
    
    /**
     * 所有一级菜单节点列表
     * @return
     */
    List<MenuInfo> selectLevelOneMenuLst();
}