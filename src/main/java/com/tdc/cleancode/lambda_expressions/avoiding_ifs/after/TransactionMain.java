package com.tdc.cleancode.lambda_expressions.avoiding_ifs.after;

import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;

public class TransactionMain {

    public static void main(String[] args) {
        Account account = new Account();
        System.out.println("Balance before the Transaction: "+account.getBalance());
        TransactionType.BUY.getDoTransaction().accept(account, BigDecimal.valueOf(100), BigDecimal.valueOf(1.5));
        System.out.println("Balance after the Transaction: "+account.getBalance());
    }
}
