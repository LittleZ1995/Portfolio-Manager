package com.citi.portfolio.entity;

public class Portfolio {
    private Integer portfolioid;

    private String name;

    private Integer managerid;

    private Double profit;

    public Integer getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(Integer portfolioid) {
        this.portfolioid = portfolioid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
	public Portfolio() {
		super();
	}

	public Portfolio(String name, Integer managerid) {
		super();
		this.name = name;
		this.managerid = managerid;
	}
    
    
}