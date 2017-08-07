package com.citi.portfolio.entity;

public class Security {
    private Integer securityid;

    private String securitytype;

    public Integer getSecurityid() {
        return securityid;
    }

    public void setSecurityid(Integer securityid) {
        this.securityid = securityid;
    }

    public String getSecuritytype() {
        return securitytype;
    }

    public void setSecuritytype(String securitytype) {
        this.securitytype = securitytype == null ? null : securitytype.trim();
    }
}