package com.example.demo.Chapter6.PolicyPattern.components;

import java.util.HashSet;
import java.util.Set;

public class ExcellentCustomerPolicy {
    private final Set<IExcellentCustomerRule> rules;
    public ExcellentCustomerPolicy(){
        rules = new HashSet<>();
    };

    /**
     * 
     * ルールを追加
     * 
     * @param rule　ルール
     */

     public void add(final IExcellentCustomerRule rule){
        rules.add(rule);
     }
     /**
      * @param history 購入履歴
      * @return ルールをすべて満たす場合true
      */
    public boolean complyWithAll(final PurchaseHistory history){
        for(IExcellentCustomerRule each:rules){
            if(!each.ok(history)) return false;
        };
        return true;
    }
}
