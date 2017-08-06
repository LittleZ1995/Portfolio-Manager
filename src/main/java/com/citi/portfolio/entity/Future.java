package com.citi.portfolio.entity;

import java.util.Date;

public class Future {
    private Integer futureid;

    private String isin;

    private Integer priceidf;

    private String symbol;

    private Date deliverydate;

    private Integer positionidf;

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

    public Integer getPriceidf() {
        return priceidf;
    }

    public void setPriceidf(Integer priceidf) {
        this.priceidf = priceidf;
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

    public Integer getPositionidf() {
        return positionidf;
    }

    public void setPositionidf(Integer positionidf) {
        this.positionidf = positionidf;
    }
}