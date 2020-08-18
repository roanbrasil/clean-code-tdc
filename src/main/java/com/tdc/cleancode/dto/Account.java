package com.tdc.cleancode.dto;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = new BigDecimal("1000");

    public static Account account(){
        return new Account();
    }

    public void addMoney(BigDecimal money){
        this.balance = this.balance.add(money);
    }

    public void removeMoney(BigDecimal money){
        this.addMoney(money.negate());
    }

    public BigDecimal getBalance(){
        return this.balance;
    }
}
