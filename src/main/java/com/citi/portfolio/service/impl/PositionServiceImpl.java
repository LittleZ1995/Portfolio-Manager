package com.citi.portfolio.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.dao.PositionMapper;
import com.citi.portfolio.service.PositionService;
import com.citi.portfolio.util.DoubleFormat;

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

	@Override
	public int updatePosition(Position position) {
		// TODO Auto-generated method stub
		return positionMapper.updateByPrimaryKey(position);
	}

	@Override
	public Double calculateProfit(Position position) {
		BigDecimal initialPrice = position.getInitialprice();
		BigDecimal currentPrice = position.getCurrentprice();
		Integer quantity = position.getQuantity();
		double newProfit = (currentPrice.doubleValue() - initialPrice.doubleValue()) * quantity;
		return DoubleFormat.format(newProfit);
	}

	@Override
	public int deletePositionById(int positionid) {
		// TODO Auto-generated method stub
		return positionMapper.deleteByPrimaryKey(positionid);
	}

	@Override
	public void formatProfit(Position position) {
		// TODO Auto-generated method stub
		position.setProfit(DoubleFormat.format(position.getProfit()));
	}

	@Override
	public void formatProfit(Collection<Position> positions) {
		// TODO Auto-generated method stub
		for (Position position : positions) {
			this.formatProfit(position);
		}
	}

}
