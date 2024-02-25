package com.example.demo.第8章密結合.密結合と責務;

public class DiscountManager {
    List<Product> discountProducts;
    int totalPrice;
    /**
     * 商品を追加する
     *
     * @param product
     * @param productDiscount
     * @return 追加に成功した場合true
     * */
    boolean add(Product product,ProductDiscount productDiscount){
        if(product.id<0){
            throw new IllegalArgumentException();
        }

    }
}
