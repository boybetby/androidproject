package com.example.lib.Model.Order;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    Order order;
    Integer ProductID;
    Integer amount;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Integer productID, Integer amount) {
        this.order = order;
        ProductID = productID;
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
