package com.example.demo.Chapter6.StrategyPattern.main;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.Chapter6.StrategyPattern.components.IMagic;
import com.example.demo.Chapter6.StrategyPattern.components.constraints.MagicType;

// Switch文を利用せずに魔法ごとの処理の切り替えを表現できている。
public class MainClassUseMagic {
    final Map<MagicType, IMagic> magics=new HashMap<>();

    void MagicAttack(final MagicType magicType){
        // interfaceでやり取りすることでif(magic.name=="shiden"){}とかswitch文を書かなくてもよくなる。
        final IMagic usingMagic = magics.get(magicType);
        showMagicName(usingMagic);
        consumeMagicPoint(usingMagic);
        consumeTechnicalpoint(usingMagic);
        magicDamage(usingMagic);
    }

    void showMagicName(final IMagic magic){
        final String name = magic.name();
        System.out.println(name);
    }
    void consumeMagicPoint(final IMagic magic){
        final int consumeMagicPoint=magic.costMagicPoint();
        System.out.println(consumeMagicPoint);
    }
    void consumeTechnicalpoint(final IMagic magic){
        final int consumeTechnicalPower=magic.costTechnicalPower();
        System.out.println(consumeTechnicalPower);
    }
    void magicDamage(final IMagic magic){
        final int attackPower = magic.attackPower();
        System.out.println(attackPower);
    }

}
