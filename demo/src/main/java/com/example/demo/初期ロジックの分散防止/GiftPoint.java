package main.java.com.example.demo.初期ロジックの分散防止;
/**
 * 悪いクラス
 */
public class GiftPoint {
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
}
