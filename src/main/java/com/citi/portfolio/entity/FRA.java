package com.citi.portfolio.entity;

public class FRA {
    private Integer fraid;

    private String isin;

    private Integer priceidfra;

    private Integer fpstart;

    private Integer fpend;

    private Double rate;

    private Integer positionidfra;

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

    public Integer getPriceidfra() {
        return priceidfra;
    }

    public void setPriceidfra(Integer priceidfra) {
        this.priceidfra = priceidfra;
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

    public Integer getPositionidfra() {
        return positionidfra;
    }

    public void setPositionidfra(Integer positionidfra) {
        this.positionidfra = positionidfra;
    }
}