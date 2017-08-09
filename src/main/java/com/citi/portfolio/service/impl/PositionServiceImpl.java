package com.citi.portfolio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.dao.PositionMapper;
import com.citi.portfolio.service.PositionService;

@Service("PositionService")
public class PositionServiceImpl implements PositionService {

	@Resource
	private PositionMapper positionMapper;
	
	@Override
	public List<Position> getAllPositionsOfPortfolio(int portfolioid) {
		// TODO Auto-generated method stub
		return positionMapper.getAllPositionsOfPortfolio(portfolioid);
	}

	@Override
	public int addPosition(Position position) {
		// TODO Auto-generated method stub
		return positionMapper.insert(position);
	}

	@Override
	public Position getPositionByPositionId(int positionid) {
		// TODO Auto-generated method stub
		return positionMapper.selectByPrimaryKey(positionid);
	}

}
