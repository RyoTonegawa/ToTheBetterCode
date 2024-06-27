package com.example.demo.Chapter6.PolicyPattern.components;

public class GoldCustomerPurchaseAmountRule implements IExcellentCustomerRule{
    @Override
    public boolean ok(final PurchaseHistory history){
        return 100000 <= history.totalAmount;
    }

}
