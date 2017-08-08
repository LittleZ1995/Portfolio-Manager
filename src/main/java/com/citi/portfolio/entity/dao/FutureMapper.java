package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.Future;

public interface FutureMapper {
    int deleteByPrimaryKey(Integer futureid);

    int insert(Future record);

    int insertSelective(Future record);

    Future selectByPrimaryKey(Integer futureid);
    
    Future selectByPrimaryKeyWithPrice(Integer futureid);

    int updateByPrimaryKeySelective(Future record);

    int updateByPrimaryKey(Future record);

	Future selectBySymbol(String symbol);
}