package com.klickkeyn.shop.store;

import com.klickkeyn.shop.cashbox.Cashbox;
import com.klickkeyn.shop.people.Buyer;
import com.klickkeyn.shop.people.Seller;
import com.klickkeyn.shop.product.Product;
import com.klickkeyn.shop.productStorage.productStorage;

import java.util.*;

public class Shop {
    private Product fish;
    private Product meat;
    private Product mayonnaise;
    private Product condoms;
    private productStorage stallFish;
    private productStorage stallMeat;
    private productStorage stallMayonnaise;
    private productStorage stallCondoms;
    private ArrayList<productStorage> stalls;
    private Queue<Buyer> queue;
    private HashSet<Buyer> buyers;
    private Iterator<Buyer> buyersIter;
    private final int workTime;
    private int workTimeCnt;

    public Shop() {
        // Stalls are filled with products
        fish = new Product("Рыба", 150, 7000);
        stallFish = new productStorage("Рыбный прилавок");
        stallFish.pushProduct(fish);

        meat = new Product("Мясо", 200, 5000);
        stallMeat = new productStorage("Мясной прилавок");
        stallMeat.pushProduct(meat);

        mayonnaise = new Product("Майонез", 50, 6000);
        stallMayonnaise = new productStorage("Прилавок с майонезом");
        stallMayonnaise.pushProduct(mayonnaise);

        condoms = new Product("Майонез", 280, 4000);
        stallCondoms = new productStorage("Лоток с презервативами");
        stallCondoms.pushProduct(condoms);

        stalls = new ArrayList<productStorage>();
        stalls.add(stallFish);
        stalls.add(stallMeat);
        stalls.add(stallMayonnaise);
        stalls.add(stallCondoms);

        // Create cashbox
        Cashbox cashbox = new Cashbox(0);

        // The seller come to work
        Seller seller = new Seller("Галечка");

        //The buyers come to shop
        queue = new LinkedList<Buyer>();
        buyers = new HashSet<Buyer>();
        buyersIter = buyers.iterator();

        //Timework of shop
        this.workTime = 12 * 60;
        this.workTimeCnt = 0;
    }

    private int randomVal(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private void newBuyer() {
        // Chance of a buyer coming
        int chanceBuyerCum = randomVal(0, 100);
        if (chanceBuyerCum > 50) {
            int buyerCash = randomVal(50, 5000);
            Buyer buyer = new Buyer(buyerCash);
            System.out.println(buyer.getName() + buyer.getState());
            productStorage busket = new productStorage("Корзина");
            buyer.takeBasket(busket);
            System.out.println(buyer.getName() + "взял корзину");
            buyer.nextState();
            this.buyers.add(buyer);

            this.workTimeCnt++;
        }
    }

    public void simulateShopWork() {
        while (this.workTimeCnt < this.workTime) {
            newBuyer();

            if (this.buyers != null) {
                Iterator<Buyer> buyersIter = buyers.iterator();
                while (buyersIter.hasNext()) {
                    Buyer buyer = buyersIter.next();
                    if (buyer.getState() == "выбирает товар") {
                        while (true) {
                            int stallIndex = randomVal(0, 3);
                            productStorage stall = this.stalls.get(stallIndex);
                            Product product = stall.popProduct(1);
                            boolean taken = buyer.pushProduct(product);

                            if (!taken) {
                                int falseCnt = 0;
                                for (productStorage stallChecked : this.stalls) {
                                    stallChecked.popProduct(1);
                                    boolean takenCheckedProduct = buyer.pushProduct(product);
                                    if (!takenCheckedProduct) {
                                        falseCnt++;
                                    }
                                }
                                if (falseCnt == this.stalls.size()) {
                                    break;
                                }
                            }
                        }
                        buyer.nextState();
                        productStorage busket = buyer.giveBasket();
                        System.out.println(busket.toString());
                        this.workTimeCnt++;
                    }
                }
            }
        }
    }
}

