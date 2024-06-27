package com.example.demo.Chapter6.PolicyPattern.components;

public interface IExcellentCustomerRule {
    /**
     * @return 条件を満たす場合true
     * @param history　購入履歴
     */
    boolean ok(final PurchaseHistory history);
}   
