package com.example.demo.Chapter6.PolicyPattern.components;

public class ReturnRateRule implements IExcellentCustomerRule {
    public boolean ok (final PurchaseHistory history){
        return history.returnRate <= 0.01;
    }
    
}
