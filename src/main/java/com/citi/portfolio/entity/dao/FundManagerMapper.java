package com.citi.portfolio.entity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.citi.portfolio.entity.FundManager;

@Repository 
public interface FundManagerMapper {
    int deleteByPrimaryKey(Integer managerid);

    int insert(FundManager record);

    int insertSelective(FundManager record);

    FundManager selectByPrimaryKey(Integer managerid);

    int updateByPrimaryKeySelective(FundManager record);

    int updateByPrimaryKey(FundManager record);
}