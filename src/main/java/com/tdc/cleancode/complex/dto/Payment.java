package com.tdc.cleancode.complex.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Payment {

    private PaymentMethod paymentMethod;
    private List<Debit> debitList;

    public Payment() {
    }

    public void add(Debit debit){
        Objects.requireNonNull(debit, "Debit is required!!!");
        if (debitList == null) {
            this.debitList = new ArrayList<>();
        }
        this.debitList.add(debit);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Debit> getDebitList() {
        if (debitList != null) {
            return debitList;
        }else{
            return Collections.emptyList();
        }
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
