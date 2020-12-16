package com.klickkeyn.shop.product;

public class Product{
    private final String name;
    private final int price;
    private int prodCnt;

    public Product(String name, int price, int prodCnt) {
        this.name = name;
        this.price = price;
        this.prodCnt = prodCnt;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getProdCnt() {
        return this.prodCnt;
    }

    public void setProdCnt(int cnt) {
        this.prodCnt = cnt;
    }
}
