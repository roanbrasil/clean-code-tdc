package com.tdc.cleancode.complex.dto;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    private PaymentMethod paymentMethod;
    private List<Debit> debitList = new ArrayList<>();

    public Payment() {
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Debit> getDebitList() {
        return debitList;
    }

    public void setDebitList(List<Debit> debitList) {
        this.debitList = debitList;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod=" + paymentMethod +
                ", debitList=" + debitList +
                '}';
    }
}
