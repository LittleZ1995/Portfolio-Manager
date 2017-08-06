package com.citi.portfolio.entity;

public class Equity {
    private Integer equityid;

    private String isin;

    private Integer priceide;

    private String symbol;

    private Integer positionide;

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

    public Integer getPriceide() {
        return priceide;
    }

    public void setPriceide(Integer priceide) {
        this.priceide = priceide;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Integer getPositionide() {
        return positionide;
    }

    public void setPositionide(Integer positionide) {
        this.positionide = positionide;
    }
}