package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance;

    public CustomerAccount(){
        this.setBalance((double) 0);
    }

    @Override
    public void add(Double addedAmount) {
        this.setBalance(getBalance()+addedAmount);
    }

    @Override
    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double newBalance){
        this.balance=newBalance;
    }

    @Override
    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
        Double resultingAccountBalance = this.getBalance() - withdrawnAmount;
        if (!rule.withdrawPermitted(resultingAccountBalance)) {
            throw new IllegalBalanceException(resultingAccountBalance);
        }
        this.balance=resultingAccountBalance;
        return this.balance;
    }
}
