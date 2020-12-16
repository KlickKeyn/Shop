package com.klickkeyn.shop.store;

import com.klickkeyn.shop.cashbox.Cashbox;
import com.klickkeyn.shop.people.Buyer;
import com.klickkeyn.shop.people.Seller;
import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Shop {
    public Shop() {
        // Stalls are filled with products
        Product fish = new Product("Рыба", 150, 70);
        productStorage stallFish = new productStorage("Рыбный прилавок");

        Product meat = new Product("Мясо", 200, 50);
        productStorage stallMeat = new productStorage("Мясной прилавок");

        Product mayonnaise = new Product("Майонез", 50, 60);
        productStorage stallMayonnaise = new productStorage("Прилавок с майонезом");

        Product condoms = new Product("Майонез", 280, 40);
        productStorage stallCondoms = new productStorage("Лоток с презервативами");

        // Create cashbox
        Cashbox cashbox = new Cashbox(0);

        // The seller come to work
        Seller seller = new Seller("Галечка");

        //The buyers come to shop
        Queue<Buyer> queue = new LinkedList<Buyer>();
        HashSet<Buyer> set = new HashSet<Buyer>();
        Iterator<Buyer> setIter = set.iterator();
    }

    private int randomVal(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void simulateShopWork() {

    }
}

