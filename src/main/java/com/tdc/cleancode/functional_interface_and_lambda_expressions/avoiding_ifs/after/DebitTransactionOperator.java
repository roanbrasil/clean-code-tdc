package com.tdc.cleancode.functional_interface_and_lambda_expressions.avoiding_ifs.after;

import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;

public abstract class DebitTransactionOperator implements TransactionService{

    public static void doDebitTransactionOperation(Account account, BigDecimal cashValue, BigDecimal percentage) {
        BigDecimal taxPercentageValue = TransactionService.calculateTax(percentage, cashValue);
        cashValue = cashValue.add(taxPercentageValue);
        account.removeMoney(cashValue);
    }
}
