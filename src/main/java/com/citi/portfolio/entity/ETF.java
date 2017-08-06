package com.citi.portfolio.entity;

public class ETF {
    private Integer etfid;

    private String isin;

    private Integer priceidetf;

    private String symbol;

    private Integer positionidetf;

    public Integer getEtfid() {
        return etfid;
    }

    public void setEtfid(Integer etfid) {
        this.etfid = etfid;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin == null ? null : isin.trim();
    }

    public Integer getPriceidetf() {
        return priceidetf;
    }

    public void setPriceidetf(Integer priceidetf) {
        this.priceidetf = priceidetf;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Integer getPositionidetf() {
        return positionidetf;
    }

    public void setPositionidetf(Integer positionidetf) {
        this.positionidetf = positionidetf;
    }
}