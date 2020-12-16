package com.klickkeyn.shop;

import com.klickkeyn.shop.people.Buyer;
import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Презики", 400, 100);
        Product product2 = new Product("Мясо", 800, 100);

        productStorage stall1 = new productStorage("Прилавок с презиками");
        productStorage stall2 = new productStorage("Прилавок с мясом");
        stall1.pushProduct(product1);
        stall2.pushProduct(product2);

        productStorage basket = new productStorage("Корзина");

        Buyer buyer1 = new Buyer(2000);
        buyer1.takeBasket(basket);

        product1 = stall1.popProduct(1);
        buyer1.pushProduct(product1);
        System.out.println(basket.getProdCnt());
        System.out.println(basket.getPrice());

        product2 = stall2.popProduct(2);
        buyer1.pushProduct(product2);
        System.out.println(basket.getProdCnt());
        System.out.println(basket.getPrice());

        buyer1.popProduct();
        System.out.println(basket.getProdCnt());
        System.out.println(basket.getPrice());

        System.out.println();
    }
}
