package com.citi.portfolio.entity;

public class FRA {
    private Integer fraid;

    private String isin;

    private Integer priceid;

    private Integer fpstart;

    private Integer fpend;

    private Double rate;

    private Integer securityid;

    public Integer getFraid() {
        return fraid;
    }

    public void setFraid(Integer fraid) {
        this.fraid = fraid;
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

    public Integer getFpstart() {
        return fpstart;
    }

    public void setFpstart(Integer fpstart) {
        this.fpstart = fpstart;
    }

    public Integer getFpend() {
        return fpend;
    }

    public void setFpend(Integer fpend) {
        this.fpend = fpend;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }
}