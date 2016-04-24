package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.IPBelong;

public interface IPBelongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IPBelong record);

    int insertSelective(IPBelong record);

    IPBelong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IPBelong record);

    int updateByPrimaryKey(IPBelong record);
}