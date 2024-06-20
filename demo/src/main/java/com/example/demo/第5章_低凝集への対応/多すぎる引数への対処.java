package com.example.demo.第5章_低凝集への対応;

import java.util.List;

/**
 * 悪いコード
 * この例では4っ程度だが、プロダクションではもっと多い引数を扱うことも。
 * 引数の多さ　=メソッドで処理したいことの多さなので、
 * 引数が増えると処理が複雑化しやすい
 */
public final class 多すぎる引数への対処 {
    int recoverMagicPoint(int currentMagicPoint,
                          int originalMaxMagicPoint,
                          List<Integer> maxMagicPointIncrements,
                          int recoveryAmount){
        int currentMaxMagicPoint = originalMaxMagicPoint;
        for (int each:maxMagicPointIncrements){
            currentMaxMagicPoint += each;
        }
        return Math.min(currentMagicPoint+recoveryAmount,
                currentMagicPoint);
    }
}

/**
 * 改善：魔法力に関係するロジックをカプセル化することで
 * 魔法力に関する操作を集約する
 */
class MagicPoint{
    private int currentAmount;
    private int originalMaxAmount;
    private final List<Integer> maxIncrements;

    MagicPoint(final int currentAmount,final List<Integer> maxIncrements) {
        this.currentAmount = currentAmount;
        this.maxIncrements = maxIncrements;
    }

    /**@reutrn 現在の魔法力残量*/
    int current(){
        return currentAmount;
    }
    /**@return 魔法力の最大量*/
    int max(){
        int amount = originalMaxAmount;
        for(int each:maxIncrements){
            amount +=each;
        }
        return amount;
    }
    /**
     * 魔法力を回復する
     */
    void recover(final int recoveryAmount){
        currentAmount = Math.min(currentAmount+recoveryAmount,max());
    }
    /**
     * 魔法力を消費する
     * */
    void consume(final int consumeAmount){
        if(consumeAmount>currentAmount){
            throw new IllegalArgumentException("魔法力をオーバーしています");
        }
        this.currentAmount += consumeAmount;
    }
}
