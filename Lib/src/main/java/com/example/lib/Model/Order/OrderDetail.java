package com.example.lib.Model.Order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    @SerializedName("Order")
    @Expose
    private Order order;
    @SerializedName("ProductID")
    @Expose
    private Integer productID;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public OrderDetail(Order order, Integer productID, Integer amount) {
        this.order = order;
        this.productID = productID;
        this.amount = amount;
    }

    public OrderDetail() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}

