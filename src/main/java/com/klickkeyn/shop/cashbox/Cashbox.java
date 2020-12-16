package com.klickkeyn.shop.cashbox;

public class Cashbox {
    private int money;

    public Cashbox(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return this.money;
    }
}
