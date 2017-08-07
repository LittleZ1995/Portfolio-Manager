package com.citi.portfolio.entity;

public class Equity {
    private Integer equityid;

    private String isin;

    private Integer priceid;

    private String symbol;

    private Integer securityid;
    
    private Price price;

    public Integer getEquityid() {
        return equityid;
    }

    public void setEquityid(Integer equityid) {
        this.equityid = equityid;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin == null ? null : isin.trim();
    }

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Equity [equityid=" + equityid + ", isin=" + isin + ", priceid=" + priceid + ", symbol=" + symbol
				+ ", securityid=" + securityid + ", price=" + price + "]";
	}
    
    
}