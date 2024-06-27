package com.example.demo.Chapter6.PolicyPattern.main;

import com.example.demo.Chapter6.PolicyPattern.components.ExcellentCustomerPolicy;
import com.example.demo.Chapter6.PolicyPattern.components.PurchaseFrequencyRule;
import com.example.demo.Chapter6.PolicyPattern.components.PurchaseHistory;
import com.example.demo.Chapter6.PolicyPattern.components.ReturnRateRule;

public class SilverCustomerPolicy {

    private final ExcellentCustomerPolicy policy;

    SilverCustomerPolicy (){
        policy = new ExcellentCustomerPolicy();
        policy.add(new PurchaseFrequencyRule());
        policy.add(new ReturnRateRule());
    };
    /**
     * @param history 購入履歴
     * @return ルールをすべて満たす場合true
     */
    boolean complyWithAll(final PurchaseHistory history){
        return policy.complyWithAll(history);
    }
}
