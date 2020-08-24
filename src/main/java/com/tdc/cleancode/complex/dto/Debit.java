package com.tdc.cleancode.complex.dto;

public class Debit {

    private String paymentTypeDescription;
    private String amountDue;
    private String totalAmountDue;
    private String totalAmountSpent;

    public Debit() {
    }

    public String getPaymentTypeDescription() {
        return paymentTypeDescription;
    }

    public void setPaymentTypeDescription(String paymentTypeDescription) {
        this.paymentTypeDescription = paymentTypeDescription;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }

    public String getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(String totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public String getTotalAmountSpent() {
        return totalAmountSpent;
    }

    public void setTotalAmountSpent(String totalAmountSpent) {
        this.totalAmountSpent = totalAmountSpent;
    }

    @Override
    public String toString() {
        return "Debit{" +
                "paymentTypeDescription='" + paymentTypeDescription + '\'' +
                ", amountDue='" + amountDue + '\'' +
                ", totalAmountDue='" + totalAmountDue + '\'' +
                ", totalAmountSpent='" + totalAmountSpent + '\'' +
                '}';
    }
}
