package com.example.demo.第5章_低凝集への対応;

import java.math.BigDecimal;
/**
 * 悪いクラス
 * 共通処理の置き場として用意されるCommonやUtilも低凝集構造となりやすい
 * →商品やユーザが退会済みの場合の処理、電話番号についての処理など、文脈の異なるロジックがたくさんある。
 * 
 * なぜ起こってしまうのか
 * →共通化や再利用性について理解が不足している事。
 */
public class Common {
    // 税込み金額を計算する
    static BigDecimal calcAmountIncludingTax(
        BigDecimal amountExcludingTax,
        BigDecimal taxRate){
            return amountExcludingTax.multiply(taxRate);
    }
    // ユーザが退会済みの場合

    // 商品を注文する

    // 有効な電話番号である場合true
}
/**
 * 改善：オブジェクト指向の基本に立ち返って共通処理を安易に作らないようにする
 */
class AmountIncludingTax{
    final BigDecimal value;
    AmountIncludingTax(
        final BigDecimal amountExcludingTax,
        final BigDecimal taxRate){
            value = amountExcludingTax.multiply(taxRate);
        }
}