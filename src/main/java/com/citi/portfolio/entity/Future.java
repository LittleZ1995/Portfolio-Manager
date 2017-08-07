package com.citi.portfolio.entity;

import java.util.Date;

public class Future {
    private Integer futureid;

    private String isin;

    private Integer priceid;

    private String symbol;

    private Date deliverydate;

    private Integer securityid;

    public Integer getFutureid() {
        return futureid;
    }

    public void setFutureid(Integer futureid) {
        this.futureid = futureid;
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

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }
}