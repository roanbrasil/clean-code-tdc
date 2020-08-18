package com.tdc.cleancode.functional_interface_and_lambda_expressions.avoiding_ifs.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface TransactionService {

    static BigDecimal calculateTax(BigDecimal percentage, BigDecimal cashValue){
        return cashValue
                .multiply(percentage)
                .divide(new BigDecimal(100), RoundingMode.HALF_DOWN);
    }
}
