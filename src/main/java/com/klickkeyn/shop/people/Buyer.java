package com.klickkeyn.shop.people;

import com.klickkeyn.shop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class Buyer implements People {

    private static Integer cnt = 0;
    private final String name;
    private int many;
    private ArrayList<String> possibleStates = new ArrayList<String>();
    private Iterator<String> possibleStatesIter;
    private String state;

    public Buyer(int many) {
        cnt++;
        this.name = "Покупатель №" + cnt.toString();
        this.many = many;
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
        return this.many;
    }

    public void nextState() {
        this.state = this.possibleStatesIter.next();
    }

    public String getState() {
        return this.state;
    }

    public void pushProduct() {

    }

    public Product popProduct() {
        return null;
    }
}
