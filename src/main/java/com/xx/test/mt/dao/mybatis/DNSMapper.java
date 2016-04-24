package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.DNS;

public interface DNSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DNS record);

    int insertSelective(DNS record);

    DNS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DNS record);

    int updateByPrimaryKey(DNS record);
}