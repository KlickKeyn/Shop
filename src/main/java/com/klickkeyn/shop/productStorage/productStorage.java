package com.klickkeyn.shop.productStorage;

import com.klickkeyn.shop.product.Product;

import java.util.ArrayList;

public class productStorage {
    private final String name;
    private ArrayList<Product> storageProd = new ArrayList<Product>();
    private int sumPrice;

    public productStorage(String name) {
        this.name = name;
        sumPrice = 0;
    }

    public String getCashboxName() {
        return this.name;
    }

    public int getProdCnt() {
        int sum = 0;
        for (Product product : this.storageProd) {
            sum += product.getProdCnt();
        }
        return sum;
    }

    public int getPrice() {
        return this.sumPrice;
    }

    public Product popProduct() {
        if (this.isEmpty()) {
            return null;
        } else {
            Product prodOut = this.storageProd.get(0);
            this.storageProd.remove(0);
            this.sumPrice -= prodOut.getPrice() * prodOut.getProdCnt();
            return prodOut;
        }
    }

    public Product popProduct(int cnt) {
        if (this.isEmpty()) {
            return null;
        } else {
            Product prod = this.storageProd.get(0);
            prod.setProdCnt(prod.getProdCnt() - cnt);
            Product prodOut = this.storageProd.get(0);
            prodOut.setProdCnt(cnt);
            return prodOut;
        }
    }

    public void pushProduct(Product prod) {
        if (prodHas(prod)) {
            int index = this.storageProd.indexOf(prod);
            Product oldProduct = this.storageProd.get(index);
            int productCurCnt = oldProduct.getProdCnt();
            int productNewCnt = prod.getProdCnt();
            productNewCnt += productCurCnt;
            this.storageProd.get(index).setProdCnt(productNewCnt);
        } else {
            this.storageProd.add(prod);
        }
        this.sumPrice += prod.getPrice();
    }

    public boolean isEmpty() {
        return this.storageProd.isEmpty();
    }

    public boolean prodHas(Product prod) {
        int index = this.storageProd.indexOf(prod);
        return index != -1;
    }
}
