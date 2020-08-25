package com.tdc.cleancode.complex.builder;


import com.tdc.cleancode.complex.dto.Debit;
import com.tdc.cleancode.complex.dto.SimpleValue;
import com.tdc.cleancode.complex.dto.ValueType;

import java.util.List;
import java.util.Objects;

public class DebitBuilder {

    private final String paymentTypeDescription;
    private String amountDue;
    private String totalAmountDue;
    private String totalAmountSpent;

    public DebitBuilder(String paymentTypeDescription){
        this.paymentTypeDescription = paymentTypeDescription;
    }


    public DebitBuilder fillDebit(List<SimpleValue> simpleValuesFromTarget){
        final Debit debit = new Debit();

        simpleValuesFromTarget
                .forEach(simpleValue ->
                        ValueType.findByName(simpleValue.getAttributeName())
                                .setDebit(debit, simpleValue.getAttributeValue())
                );

        this.amountDue =  debit.getAmountDue();
        this.totalAmountDue = debit.getTotalAmountDue();
        this.totalAmountSpent = debit.getTotalAmountSpent();

        return this;
    }

    public Debit build(){
        Debit debit = new Debit();
        debit.setPaymentTypeDescription(this.paymentTypeDescription);
        debit.setAmountDue(this.amountDue);
        debit.setTotalAmountDue(this.totalAmountDue);
        debit.setTotalAmountSpent(this.totalAmountSpent);

        return debit;
    }
}
