package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.FRA;

public interface FRAMapper {
    int deleteByPrimaryKey(Integer fraid);

    int insert(FRA record);

    int insertSelective(FRA record);

    FRA selectByPrimaryKey(Integer fraid);

    int updateByPrimaryKeySelective(FRA record);

    int updateByPrimaryKey(FRA record);
}