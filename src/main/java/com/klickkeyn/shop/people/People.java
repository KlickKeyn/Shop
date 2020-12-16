package com.klickkeyn.shop.people;

import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

public interface People {
    int getMoney();

    void nextState();

    String getState();

    boolean pushProduct(Product product);

    Product popProduct();

    void takeBasket(productStorage basket);

    productStorage giveBasket();
}
