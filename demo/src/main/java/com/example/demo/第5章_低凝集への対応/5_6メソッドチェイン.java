package com.example.demo.第5章_低凝集への対応;
/**
 * 悪いコード
 * partyのmemberのequipの、、、というように数珠繋ぎで値を取得する事を
 * メソッドチェインと呼ぶ
 * なぜ悪いのか？
 * 1.このコードではarmorに代入しているが、代入するコードをどこでもかけてしまう
 * 　　→要素への代入が容易にできるため低凝集に陥る
 */
/**
 * 鎧を装備する
 */
public void equipArmor(int memberId,Armor newArmor){
    if(party.members[menberId].equipments.canChange){
        party.members[memberId].equipments.armor = newArmor;
        }
}
/**
 * 改善：詳細なメソッドは呼ぶ側ではなく、呼ばれる側に実装する
 * デメテルの法則
 * 他のオブジェクトの状態をたずねたり状態に応じて呼び出し側が判断するのではなく、
 * 呼び出し側はただメソッドで命じるだけで命令された側で適切な判断や制御をするように設計する
 */
class Equipments{
    private boolean canChange;
    private Equipment head;
    private Equipment armor;
    private Equipment arm;
    void equipArmor(final Equipment newArmor){
        if(canChange){
            armor = newArmor;
        }
    }
    /**
     * 全装備を解除する
     * */
    void detachableAll(){
        head = Equipment.EMPTY;
        armor = Equipment.EMPTY;
        arm = Equipment.EMPTY;
    }
}
class Equipment{
    /**
     * 略
     * */

}