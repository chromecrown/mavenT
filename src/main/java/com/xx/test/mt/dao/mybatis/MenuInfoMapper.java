package com.xx.test.mt.dao.mybatis;

import java.util.List;
import com.xx.test.mt.model.MenuInfo;

public interface MenuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo menuInfo);
    
    int selectCount();
    
    int selectByMenuHref(MenuInfo menuInfo);
    
    /**
     * 所有菜单列表
     * 
     * @return
     */
    List<MenuInfo> selectMenuLst();
}