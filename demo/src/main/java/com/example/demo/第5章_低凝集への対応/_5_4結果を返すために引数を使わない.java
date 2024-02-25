package com.example.demo.第5章_低凝集への対応;


/**
 * 悪いクラス
 * Locationというインスタンスを渡して引数のｘｙ座標を変更している。
 * このように処理結果(=出力)として利用する引数を出力引数と呼ぶ
 * →データを保持するクラスとデータを操作するロジックが別のメソッドに実装されている
 */
public class ActorManager {
    // キャラクターの位置を変更する
    void shift(Location location,int shiftX,int ShiftY){
        Location.x += shiftX;
        Location.y += ShiftY;
    }
    
}
/**
 * 改善：オブジェクト指向の基本に立ち返ってデータと操作のロジックを同じクラスに実装する
 */
class Location{
    final int x;
    final int y;
    Location(final int x ,final int y){
        this.x = x;
        this.y = y;
    }
    Location shift(final int shiftX,int ShiftY){
        final int nextX = shiftX;
        final int nextY = ShiftY;
        return new Location(nextX,nextY);
    }
}
