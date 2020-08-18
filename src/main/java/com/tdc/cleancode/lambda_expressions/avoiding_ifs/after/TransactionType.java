package com.tdc.cleancode.lambda_expressions.avoiding_ifs.after;

import com.tdc.cleancode.dto.Account;
import org.apache.logging.log4j.util.TriConsumer;

import java.math.BigDecimal;
import java.util.function.BiConsumer;


public enum TransactionType {
        SELL(CreditTransactionOperator::doCreditTransactionOperation),
        BUY(DebitTransactionOperator::doDebitTransactionOperation),
        DEPOSIT(CreditTransactionOperator::doCreditTransactionOperation),
        WITHDRAWAL(DebitTransactionOperator::doDebitTransactionOperation);
        private final TriConsumer<Account, BigDecimal, BigDecimal> doTransaction;

        TransactionType(TriConsumer<Account, BigDecimal, BigDecimal> doTransaction) {
                this.doTransaction = doTransaction;
        }

        public TriConsumer<Account, BigDecimal, BigDecimal> getDoTransaction(){
                return  doTransaction;
        }
}
