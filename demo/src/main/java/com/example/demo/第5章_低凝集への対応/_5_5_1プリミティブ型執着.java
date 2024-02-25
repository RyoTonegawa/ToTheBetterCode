package com.example.demo.第5章_低凝集への対応;


/**
 *悪いコード
 * プリミティブ型執着＝クラスを作成せずにプリミティブ型を多用すること。
 * Javaが用意しているプリミティブ型を用いると下記のようにバリデーションロジックが
 * コードのあちこちに散乱してしまう
 */
class Common{
    void discountPrice(int regularPrice,
                      float discountRate){
        if (regularPrice < 0){
            throw new IllegalArgumentException();
        }
        if(discountRate<0.0f){
            throw new IllegalArgumentException();
        }
    }
}
class Util{
    boolean isFairPrice(int regularPrice){
        if(regularPrice < 0){
            throw new IllegalArgumentException();
        }
        return true;
    }
}