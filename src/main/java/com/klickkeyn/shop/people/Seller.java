package com.klickkeyn.shop.people;

import com.klickkeyn.shop.product.Product;

public class Seller implements People {
    private int many;

    public Seller(int many) {
        this.many = many;
    }

    public int getMoney() {
        return 0;
    }

    public void nextState() {

    }

    public String getState() {
        return null;
    }

    public void pushProduct() {

    }

    public Product popProduct() {
        return null;
    }
}
