package com.tongtech.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Customers {
    private Integer custId;

    private String custName;

    private String custAddress;

    private String custCity;

    private Date insertTime;

    private String custState;

    private String custZip;

    private String custCountry;

    private String custContact;

    private String custEmail;

    private BigDecimal decimal;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity == null ? null : custCity.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState == null ? null : custState.trim();
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip == null ? null : custZip.trim();
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry == null ? null : custCountry.trim();
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact == null ? null : custContact.trim();
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custCity='" + custCity + '\'' +
                ", insertTime=" + insertTime +
                ", custState='" + custState + '\'' +
                ", custZip='" + custZip + '\'' +
                ", custCountry='" + custCountry + '\'' +
                ", custContact='" + custContact + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", decimal=" + decimal +
                '}';
    }
}