package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.UserGrp;

public interface UserGrpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGrp record);

    int insertSelective(UserGrp record);

    UserGrp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGrp record);

    int updateByPrimaryKey(UserGrp record);
}