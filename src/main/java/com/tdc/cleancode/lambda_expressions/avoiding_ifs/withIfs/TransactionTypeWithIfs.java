package com.tdc.cleancode.lambda_expressions.avoiding_ifs.withIfs;

import com.tdc.cleancode.dto.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TransactionTypeWithIfs {

    public void doTransactionOperation(Account account, BigDecimal cashValue, String operation){
        if(("buy").equalsIgnoreCase(operation)){
            BigDecimal taxPercentageValue = cashValue
                    .multiply(BigDecimal.valueOf(0.15))
                    .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }else if (("sell").equalsIgnoreCase(operation)){
            BigDecimal taxPercentageValue = cashValue
                .multiply(BigDecimal.valueOf(0.1))
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);

        }else if(("deposit").equalsIgnoreCase(operation)) {
            BigDecimal taxPercentageValue = cashValue
                    .multiply(BigDecimal.valueOf(0.05))
                    .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
            cashValue = cashValue.add(taxPercentageValue.negate());
            account.addMoney(cashValue);

        }else if(("withdrawal").equalsIgnoreCase(operation)) {
            BigDecimal taxPercentageValue = cashValue
                    .multiply(BigDecimal.valueOf(0.20))
                    .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
            cashValue = cashValue.add(taxPercentageValue);
            account.removeMoney(cashValue);
        }
    }

}
