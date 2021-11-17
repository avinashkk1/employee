package com;

public class Tax {
    private int taxID;
    private String taxType;
    private int taxPercentage;

    public Tax(int taxID, String taxType, int taxPercentage) {
        this.taxID = taxID;
        this.taxType = taxType;
        this.taxPercentage = taxPercentage;
    }

    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxID=" + taxID +
                ", taxType='" + taxType + '\'' +
                ", taxPercentage=" + taxPercentage +
                '}';
    }
}
