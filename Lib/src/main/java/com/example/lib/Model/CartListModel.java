package com.example.lib.Model;

import java.io.Serializable;

public class CartListModel implements Serializable {
    ProductsModel product;
    int amount;

    public CartListModel() {
    }

    public CartListModel(ProductsModel product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public ProductsModel getProduct() {
        return product;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
