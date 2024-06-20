package com.example.demo.Chapter6.StrategyPattern.components.Magics;

import com.example.demo.Chapter6.StrategyPattern.components.IMagic;
import com.example.demo.Chapter6.StrategyPattern.components.Member;

public class Fire implements IMagic {
    private final Member member;

    Fire(final Member member){
        this.member = member;
    }

    public String name(){
        return "fire";
    }

    public int costMagicPoint(){
        return 2;
    }

    public int attackPower(){
        return 4 +(int)(member.getLevel()*0.5);
    };

    public int costTechnicalPower(){
        return 0;
    }

}
