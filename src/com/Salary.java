package com;

public class Salary {
    private double totalEarnings;
    private double deductions;
    private double netPay;

    public Salary(double totalEarnings) {
        this.totalEarnings = totalEarnings;
        this.deductions = 0;
        this.netPay = totalEarnings;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public double getDeductions() {
        return deductions;
    }

    public void addDeductions(double deductions) {
        this.deductions += deductions;
        this.netPay -= deductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "totalEarnings=" + String.format("%.2f", totalEarnings) +
                ", deductions=" + String.format("%.2f", deductions) +
                ", netPay=" + String.format("%.2f", netPay) +
                '}';
    }
}
