package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.IP;

public interface IPMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IP record);

    int insertSelective(IP record);

    IP selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IP record);

    int updateByPrimaryKey(IP record);
}