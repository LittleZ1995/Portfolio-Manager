package com.citi.portfolio.service;

import java.math.BigDecimal;
import java.util.List;

import com.citi.portfolio.entity.Position;

public interface PositionService {

	public List<Position> getAllPositionsOfPortfolio(int portfolioid);
	
	Position getPositionByPositionId(int positionid);
	
	public int addPosition(Position position);

	public int updatePosition(Position position);
	
	public Double calculateProfit(Position position);
	
	public int deletePositionById(int positionid);
}
