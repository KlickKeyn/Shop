package com.klickkeyn.shop;

import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Презики", 400, 2);
        Product product2 = new Product("Мясо", 800, 3);
        productStorage cashbox = new productStorage("Корзина");
        cashbox.pushProduct(product1);
        cashbox.pushProduct(product2);
        cashbox.pushProduct(product2);

        System.out.println(cashbox.getCashboxName());
        System.out.println(cashbox.getProdCnt());
        cashbox.popProduct();
        System.out.println(cashbox.getProdCnt());
    }
}
