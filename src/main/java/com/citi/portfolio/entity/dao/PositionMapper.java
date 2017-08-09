package com.citi.portfolio.entity.dao;

import java.util.List;

import com.citi.portfolio.entity.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    List<Position> getAllPositionsOfPortfolio(int portfolioid);
    
}