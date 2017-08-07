package com.citi.portfolio.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Price {
    private Integer priceid;

    private BigDecimal bidprice;

    private BigDecimal offerprice;

    private String currency;

    private Date date;

    private Integer securityid;

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public BigDecimal getBidprice() {
        return bidprice;
    }

    public void setBidprice(BigDecimal bidprice) {
        this.bidprice = bidprice;
    }

    public BigDecimal getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(BigDecimal offerprice) {
        this.offerprice = offerprice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }
}