package com.example.lib.Model;

import java.io.Serializable;

public class CartListModel implements Serializable {
    DrinkModel product;
    int amount;

    public CartListModel() {
    }

    public CartListModel(DrinkModel product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public DrinkModel getProduct() {
        return product;
    }

    public void setProduct(DrinkModel product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
