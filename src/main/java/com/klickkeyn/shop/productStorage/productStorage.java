package com.klickkeyn.shop.productStorage;

import com.klickkeyn.shop.product.Product;

import java.util.ArrayList;

public class productStorage {
    private final String name;
    private ArrayList<Product> storageProd = new ArrayList<Product>();

    public productStorage(String name) {
        this.name = name;
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
        int sum = 0;
        if (!this.isEmpty()) {
            for (Product product : this.storageProd) {
                sum += product.getPrice() * product.getProdCnt();
            }
            return sum;
        } else {
            return 0;
        }
    }

    public Product popProduct() {
        if (this.isEmpty()) {
            return null;
        } else {
            Product prodOut = this.storageProd.get(0);
            this.storageProd.remove(0);
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
    }

    public boolean isEmpty() {
        return this.storageProd.isEmpty();
    }

    public boolean prodHas(Product prod) {
        int index = this.storageProd.indexOf(prod);
        return index != -1;
    }
}
