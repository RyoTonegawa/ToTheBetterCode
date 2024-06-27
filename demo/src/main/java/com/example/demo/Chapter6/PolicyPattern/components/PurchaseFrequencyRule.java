package com.example.demo.Chapter6.PolicyPattern.components;

public class PurchaseFrequencyRule implements IExcellentCustomerRule {
    public boolean ok (final PurchaseHistory history){
        return 10 <= history.purchaseFrequencyPerMonth;
    }
    
}
