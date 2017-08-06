package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.FundManager;

public interface FundManagerMapper {
    int deleteByPrimaryKey(Integer managerid);

    int insert(FundManager record);

    int insertSelective(FundManager record);

    FundManager selectByPrimaryKey(Integer managerid);

    int updateByPrimaryKeySelective(FundManager record);

    int updateByPrimaryKey(FundManager record);
}