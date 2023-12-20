package com.csmanager.carrer;

public class Shop {
    private String nameOfProduct;
    private int priceOfProduct;

    public Shop(String nameOfProduct, int priceOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
    }

    @Override
    public String toString() {
        return nameOfProduct + " val:" + priceOfProduct + "\n";
    }
}
