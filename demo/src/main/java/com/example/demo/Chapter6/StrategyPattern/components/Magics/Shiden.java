package com.example.demo.Chapter6.StrategyPattern.components.Magics;

import com.example.demo.Chapter6.StrategyPattern.components.IMagic;
import com.example.demo.Chapter6.StrategyPattern.components.Member;

public class Shiden implements IMagic {
    private final Member member;

    Shiden(final Member member){
        this.member = member;
    }

    public String name(){
        return "shiden";
    }

    public int costMagicPoint(){
        return 4;
    }

    public int attackPower(){
        return 8 +(int)(member.getLevel()*0.5);
    };

    public int costTechnicalPower(){
        return 5;
    }

}
