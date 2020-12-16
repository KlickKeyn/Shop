package com.klickkeyn.shop.people;

import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

import java.util.ArrayList;
import java.util.Iterator;

public class Buyer implements People {

    private static Integer cnt = 0;
    private final String name;
    private int money;
    private ArrayList<String> possibleStates = new ArrayList<String>();
    private Iterator<String> possibleStatesIter;
    private String state;
    private productStorage basket;

    public Buyer(int money) {
        cnt++;
        this.name = "Покупатель №" + cnt.toString();
        this.money = money;
        possibleStates.add("Пришёл");
        possibleStates.add("Выбирает товар");
        possibleStates.add("Выбрал товар");
        possibleStates.add("Ожидает в очереди");
        possibleStates.add("Обслуживается");
        possibleStates.add("Обслужен");
        this.possibleStatesIter = possibleStates.iterator();
        this.state = possibleStatesIter.next();
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public void nextState() {
        this.state = this.possibleStatesIter.next();
    }

    public String getState() {
        return this.state;
    }

    public boolean pushProduct(Product product) {
        int newPrice = this.basket.getPrice() + product.getPrice();
        if (newPrice <= this.money) {
            this.basket.pushProduct(product);
            return true;
        } else {
            return false;
        }
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

    public int buy() {
        this.money -= this.basket.getPrice();
        return this.basket.getPrice();
    }
}
