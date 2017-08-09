package com.citi.portfolio.entity;

import java.math.BigDecimal;

public class Position {
    private Integer positionid;

    private Integer portfolioid;

    private Integer quantity;

    private BigDecimal initialprice;

    private BigDecimal currentprice;

    private Integer securityid;

    private Double profit;

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(Integer portfolioid) {
        this.portfolioid = portfolioid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getInitialprice() {
        return initialprice;
    }

    public void setInitialprice(BigDecimal initialprice) {
        this.initialprice = initialprice;
    }

    public BigDecimal getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(BigDecimal currentprice) {
        this.currentprice = currentprice;
    }

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

	public Position(Integer portfolioid, Integer quantity, BigDecimal initialprice, BigDecimal currentprice,
			Integer securityid, Double profit) {
		super();
		this.portfolioid = portfolioid;
		this.quantity = quantity;
		this.initialprice = initialprice;
		this.currentprice = currentprice;
		this.securityid = securityid;
		this.profit = profit;
	}

	public Position() {
		super();
	}
    
    
}