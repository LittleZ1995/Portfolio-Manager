package com.citi.portfolio.entity;

public class Equity extends Security{
    private Integer equityid;

    private String isin;

    private Integer priceid;

    private String symbol;

    private Integer securityid;

    private String sector;

    private String industry;
    
    private String Price;

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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector == null ? null : sector.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	
	
	public Equity() {
		super();
	}

	
	
	public Equity(String isin, Integer priceid, String symbol, Integer securityid, String sector, String industry,
			String price) {
		super();
		this.isin = isin;
		this.priceid = priceid;
		this.symbol = symbol;
		this.securityid = securityid;
		this.sector = sector;
		this.industry = industry;
		Price = price;
	}

	@Override
	public String toString() {
		return "Equity [equityid=" + equityid + ", isin=" + isin + ", priceid=" + priceid + ", symbol=" + symbol
				+ ", securityid=" + securityid + ", sector=" + sector + ", industry=" + industry + ", Price=" + Price
				+ "]";
	}
    
    
}