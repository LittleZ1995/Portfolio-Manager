package com.citi.portfolio.entity;

import java.math.BigDecimal;

public class Position {
    private Integer positionid;

    private Integer portfolioid;

    private Integer quantity;

    private BigDecimal lastprice;

    private String securitytype;

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

    public BigDecimal getLastprice() {
        return lastprice;
    }

    public void setLastprice(BigDecimal lastprice) {
        this.lastprice = lastprice;
    }

    public String getSecuritytype() {
        return securitytype;
    }

    public void setSecuritytype(String securitytype) {
        this.securitytype = securitytype == null ? null : securitytype.trim();
    }
}