package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.Bond;

public interface BondMapper {
    int deleteByPrimaryKey(Integer bondid);

    int insert(Bond record);

    int insertSelective(Bond record);

    Bond selectByPrimaryKey(Integer bondid);

    int updateByPrimaryKeySelective(Bond record);

    int updateByPrimaryKey(Bond record);
}