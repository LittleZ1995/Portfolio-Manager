package com.citi.portfolio.entity.dao;

import java.util.List;

import com.citi.portfolio.entity.Security;

public interface SecurityMapper {
    int deleteByPrimaryKey(Integer securityid);

    int insert(Security record);

    int insertSelective(Security record);

    Security selectByPrimaryKey(Integer securityid);

    int updateByPrimaryKeySelective(Security record);

    int updateByPrimaryKey(Security record);
    
    Security getSecurityTypeById(int securityid);
}