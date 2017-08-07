package com.citi.portfolio.entity;

public class Equity {
    private Integer equityid;

    private String isin;

    private Integer priceid;

    private String symbol;

    private Integer securityid;

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
}