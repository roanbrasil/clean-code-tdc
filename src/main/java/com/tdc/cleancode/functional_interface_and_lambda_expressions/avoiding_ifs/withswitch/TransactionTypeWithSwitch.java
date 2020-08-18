package com.tdc.cleancode.functional_interface_and_lambda_expressions.avoiding_ifs.withswitch;

import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TransactionTypeWithSwitch {
    enum Type {
        SELL, BUY, DEPOSIT, WITHDRAWAL;
    }

    private final Type type;

    public TransactionTypeWithSwitch(Type type){
        this.type = type;
    }

    class TransactionService {

        protected void doBuyTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.15), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }

        protected void doSellTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.1), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }

        protected void doDepositTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.05), cashValue);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);
        }

        protected void doWithdrawalTransactionOperation(Account account, BigDecimal cashValue){
            BigDecimal taxPercentageValue = calculateTax(BigDecimal.valueOf(0.20), cashValue);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }

        public void doTransactionOperation(TransactionTypeWithSwitch.Type type, Account account, BigDecimal cashValue){
            switch (type){
                case BUY: doBuyTransactionOperation(account, cashValue);
                case SELL: doSellTransactionOperation(account, cashValue);
                case DEPOSIT: doDepositTransactionOperation(account, cashValue);
                case WITHDRAWAL: doWithdrawalTransactionOperation(account, cashValue);
                default: throw new IllegalArgumentException();
            }
        }

        private  BigDecimal calculateTax(BigDecimal percentage, BigDecimal cashValue){
            return cashValue
                    .multiply(percentage)
                    .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
        }
    }

}
