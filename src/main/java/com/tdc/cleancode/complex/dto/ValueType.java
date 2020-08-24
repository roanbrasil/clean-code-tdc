package com.tdc.cleancode.complex.dto;

import java.util.Arrays;

public enum ValueType {
    AMOUNT_DUE{
        @Override
        public void setDebit(Debit debit, String amountValue){
            debit.setAmountDue(amountValue);
        }
    },
    TOTAL_AMOUNT_DUE{
        @Override
        public void setDebit(Debit debit, String amountValue){
            debit.setTotalAmountDue(amountValue);
        }
    },
    TOTAL_AMOUNT_SPENT{
        @Override
        public void setDebit(Debit debit, String amountValue){
            debit.setTotalAmountSpent(amountValue);
        }
    };

    public abstract void setDebit(Debit debit, String amountValue);

    public static ValueType findByName(String name){
        return Arrays.stream(ValueType.values())
                .filter(valueType -> name.equals(valueType.name()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
