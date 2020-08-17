package com.tdc.cleancode.lambda_expressions.avoiding_ifs.after;

import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;

public abstract class CreditTransactionOperator implements TransactionService {

    public static void doCreditTransactionOperation(Account account, BigDecimal cashValue, BigDecimal percentage) {
        BigDecimal taxPercentageValue = TransactionService.calculateTax(percentage, cashValue);
        cashValue = cashValue.add(taxPercentageValue.negate());
        account.addMoney(cashValue);
    }
}
