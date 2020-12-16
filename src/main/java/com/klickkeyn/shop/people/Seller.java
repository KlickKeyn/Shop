package com.klickkeyn.shop.people;

import com.klickkeyn.shop.cashbox.Cashbox;
import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Seller implements People {
    private final String name;
    private static Integer cnt = 0;
    private List<String> possibleStates = new ArrayList<String>();
    private Iterator<String> possibleStatesIter;
    private String state;
    private productStorage basket;
    private Cashbox cashbox;

    public Seller(String name) {
        this.name = name;
        cashbox = new Cashbox(0);
        possibleStates.add("Ожидает");
        possibleStates.add("Обслуживает покупателя");
        this.possibleStatesIter = possibleStates.iterator();
        this.state = possibleStatesIter.next();
    }

    public int getMoney() {
        return cashbox.getMoney();
    }

    public void nextState() {
        this.state = this.possibleStatesIter.next();
    }

    public void setFirstState() {
        this.possibleStatesIter = possibleStates.iterator();
        this.state = possibleStatesIter.next();
    }

    public String getState() {
        return this.state;
    }

    public boolean pushProduct(Product product) {
        this.basket.pushProduct(product);
        return true;
    }

    public Product popProduct() {
        return this.basket.popProduct();
    }

    public void takeBasket(productStorage basket) {
        this.basket = basket;
    }

    public productStorage giveBasket() {
        productStorage basket = this.basket;
        this.basket = null;
        return basket;
    }
}
