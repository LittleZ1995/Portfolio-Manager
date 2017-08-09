package com.citi.portfolio.entity;

import java.util.Date;

public class Profit {
    private Integer profitid;

    private Integer portfolioid;

    private Double profitvalue;

    private Date date;

    public Integer getProfitid() {
        return profitid;
    }

    public void setProfitid(Integer profitid) {
        this.profitid = profitid;
    }

    public Integer getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(Integer portfolioid) {
        this.portfolioid = portfolioid;
    }

    public Double getProfitvalue() {
        return profitvalue;
    }

    public void setProfitvalue(Double profitvalue) {
        this.profitvalue = profitvalue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}