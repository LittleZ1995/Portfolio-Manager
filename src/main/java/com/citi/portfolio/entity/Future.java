package com.citi.portfolio.entity;

import java.util.Date;

public class Future {
    private Integer futureid;

    private String symbol;

    private Date deliverydate;

    private String isin;

    private Integer priceid;

    private Integer securityid;
    
    private Price price;

    public Integer getFutureid() {
        return futureid;
    }

    public void setFutureid(Integer futureid) {
        this.futureid = futureid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
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
		return "Future [futureid=" + futureid + ", symbol=" + symbol + ", deliverydate=" + deliverydate + ", isin="
				+ isin + ", priceid=" + priceid + ", securityid=" + securityid + ", price=" + price + "]";
	}
    
    
}