package com.citi.portfolio.entity;

import java.util.Date;

public class Bond {
    private Integer bondid;

    private String isin;

    private Integer priceidb;

    private Integer positionidb;

    private String issuer;

    private Double coupon;

    private Date maturity;

    public Integer getBondid() {
        return bondid;
    }

    public void setBondid(Integer bondid) {
        this.bondid = bondid;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin == null ? null : isin.trim();
    }

    public Integer getPriceidb() {
        return priceidb;
    }

    public void setPriceidb(Integer priceidb) {
        this.priceidb = priceidb;
    }

    public Integer getPositionidb() {
        return positionidb;
    }

    public void setPositionidb(Integer positionidb) {
        this.positionidb = positionidb;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer == null ? null : issuer.trim();
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }
}