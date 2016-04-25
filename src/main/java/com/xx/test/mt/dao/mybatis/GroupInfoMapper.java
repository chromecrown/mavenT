package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.GroupInfo;

public interface GroupInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupInfo record);

    int insertSelective(GroupInfo record);

    GroupInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupInfo record);

    int updateByPrimaryKey(GroupInfo record);
}