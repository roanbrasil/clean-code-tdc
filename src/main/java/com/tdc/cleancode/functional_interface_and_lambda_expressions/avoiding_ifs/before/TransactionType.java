package com.tdc.cleancode.functional_interface_and_lambda_expressions.avoiding_ifs.before;


import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum TransactionType {

    BUY {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.15), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    },
    SELL {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.1), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }
    },
    DEPOSIT {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.05), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }
    },
    WITHDRAWAL {
        @Override
        public void doTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.20), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    };

     public abstract void doTransactionOperation(Account account, BigDecimal cashValue);

     BigDecimal calculateTax(BigDecimal percentage, BigDecimal cashValue){
       return cashValue
                .multiply(percentage)
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
    }


    public static void main(String[] args) {
        Account account = new Account();
        System.out.println("Balance before the Transaction: "+account.getBalance());
        TransactionType.WITHDRAWAL.doTransactionOperation(account, BigDecimal.valueOf(100));
        System.out.println("Balance after the Transaction: "+account.getBalance());
    }
}
