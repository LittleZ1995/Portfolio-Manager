package com.citi.portfolio.entity;

import java.util.Date;

public class Bond extends Security{
	private Integer bondid;

	private String isin;

	private Integer priceid;

	private String issuer;

	private Double coupon;

	private Date maturity;

	private Integer securityid;

	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

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

	public Integer getPriceid() {
		return priceid;
	}

	public void setPriceid(Integer priceid) {
		this.priceid = priceid;
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

	public Integer getSecurityid() {
		return securityid;
	}

	public void setSecurityid(Integer securityid) {
		this.securityid = securityid;
	}
	
	public Bond() {
		super();
	}
	
	public Bond(String isin, Integer priceid, String issuer, Double coupon, Date maturity, Integer securityid,
			Price price) {
		super();
		this.isin = isin;
		this.priceid = priceid;
		this.issuer = issuer;
		this.coupon = coupon;
		this.maturity = maturity;
		this.securityid = securityid;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bond [bondid=" + bondid + ", isin=" + isin + ", priceid=" + priceid + ", issuer=" + issuer + ", coupon="
				+ coupon + ", maturity=" + maturity + ", securityid=" + securityid + ", price=" + price + "]";
	}

}