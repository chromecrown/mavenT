package com.xx.test.mt.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.xx.test.mt.model.IP;

public interface IPMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IP record);

    int insertSelective(IP record);

    IP selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IP record);

    int updateByPrimaryKey(IP record);
    
    List<IP> getIPLst();
    
    List<IP> getIPPageLst(Map arg);
}