package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.IPInfo;

public interface IPInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IPInfo record);

    int insertSelective(IPInfo record);

    IPInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IPInfo record);

    int updateByPrimaryKey(IPInfo record);
}