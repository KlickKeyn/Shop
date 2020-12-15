package com.klickkeyn.shop.people;

import com.klickkeyn.shop.product.Product;

public interface People {
    int getMoney();

    void nextState();

    String getState();

    void pushProduct();

    Product popProduct();
}
