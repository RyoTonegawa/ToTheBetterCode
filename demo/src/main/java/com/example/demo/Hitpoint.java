package main.java.com.example.demo;

/**
 * 悪いクラス 
 * ゲームのダメージ計算をする例
 * 問題点：
 *  tmpの意味がコロコロと変わるので読み手に混乱を与える
*/
class BadHitPoint{
    damage(){
    // キャラクターの腕力と武器性能が基本攻撃力
    tmp = Character.power()+Character.weaponAttack();
    // キャラのスピードで攻撃力を補正
    tmp = (int)(tmp*(1f + Character.speed()/100f));
    // 攻撃力から敵の防御力を差し引いたのがダメージ
    tmp = tmp -(int)(enemy.defence / 2);
    // ダメージの値が負数にならないように補正する
    tmp = Math.max(0,tmp);
    return tmp;
    }
}
/**
 * 良いクラス
 * 変数にはfinalを付けて不変にする
 */
class GoodHitPoint{
    private static final int MIN =0;
    int amount;
    void HitPoint(final int amount){
        if(amount < MIN){
            throw new IllegalArgumentException();
        }
        this.amount = amount;
    }
    /**
     * ダメージを受ける
     */
    void damage(final int damageAmount){
        final int nextAmount = amount-damageAmount;
        amount = Math.max(MIN, nextAmount);
    }
    /**
     * ヒットポイントがゼロであればtrue
     * @return
     */
    boolean isZero(){
        return amount == MIN;

    }
}
class Character{
    final GoodHitPoint hitPoint;
    final States states;
    //中略
    /**
     * ダメージを受ける
     */
    void damage(final int damageAmount){
        hitPoint.damage(damageAmount);
        if (hitPoint.isZero()){
            // 状態変更を発生させるメソッドをミューテーターと呼ぶ
            states.add(StateType.dead);
        }
    }
}
