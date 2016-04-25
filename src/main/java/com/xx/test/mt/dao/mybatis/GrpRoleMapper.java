package com.xx.test.mt.dao.mybatis;

import com.xx.test.mt.model.GrpRole;

public interface GrpRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrpRole record);

    int insertSelective(GrpRole record);

    GrpRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrpRole record);

    int updateByPrimaryKey(GrpRole record);
}