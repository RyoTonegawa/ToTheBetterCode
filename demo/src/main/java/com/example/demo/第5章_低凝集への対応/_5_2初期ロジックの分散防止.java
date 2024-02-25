package com.example.demo.第5章_低凝集への対応;
/**
 * 悪いクラス
 */
/**
 * 下記の実装では下記のようにロジックが分散する
 * なぜ？→コンストラクタを外部に公開してしまっているため
 * 
 * 例：
 * 通常会員は1000ポイント
 *      Giftpoint standardMember = new GiftPoint(1000)
 * プレミアム会員は5000ポイント
 *      Giftpoint premiumMember = new GiftPoint(5000)
 */
public class BadGiftPoint {
    private static final int MIN_POINT = 0;
    final int value;
    GiftPoint(final int point){
        if (point < MIN_POINT){
            throw new IllegalArgumentException("ポイントが０以上ではありません");
        }
        value = point;
    }
    /**
     * ポイントを加算する
     * @param other　
     * @return
     */
    GiftPoint add(final GiftPoint other){
        return new GiftPoint(value + other.value);
    }
    /**
     * 残余ポイントが消費ポイント以上であればtrue
     * @param point
     * @return
     */
    boolean isEnough(final ConsumptionPoint point){
        return point.value <= value;
    }
    /**
     * ポイントを消費する
     */
    GiftPoint consume(final ConsumptionPoint point){
        if(!isEnough(point)){
            throw new IllegalArgumentException("ポイントが不足しています");
        }
        return new GiftPoint(value - point.value);
    }
}


 /**
  * 改善：ファクトリメソッドでコンストラクタを呼ぶ。
    そのほか、生成に長いロジックが必要になる場合もクラスで何をしたいのかわかりにくくなるため
    専門のファクトリメソッドとして分離することを検討する。
  */
  public class GoodGiftPoint {
    private static final int MIN_POINT = 0;
    private static final int STANDARD_MENBERSHIP_POINT = 1000;
    private static final int PREMIUM_MENBERSHIP_POINT = 5000;
    final int value;
    private GiftPoint(final int point){
        if (point < MIN_POINT){
            throw new IllegalArgumentException("ポイントが０以上ではありません");
        }
        value = point;
    }
    /**
     * 標準会員向けポイントを加算する
     * @param other　
     * @return
     */
    static GiftPoint forStandardMember(final GiftPoint other){
        return new GiftPoint(STANDARD_MENBERSHIP_POINT);
    }
    /**
     * プレミアム会員向けポイントを加算する
     * @param other　
     * @return
     */
    static GiftPoint forPremiumMember(final GiftPoint other){
        return new GiftPoint(PREMIUM_MENBERSHIP_POINT);
    }
    // 省略
}