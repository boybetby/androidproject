package com.example.lib.Model.Order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    @SerializedName("OrderID")
    @Expose
    private String orderid;
    @SerializedName("ProductID")
    @Expose
    private Integer productID;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public OrderDetail() {

    }

    public OrderDetail(String orderid, Integer productID, Integer amount) {
        this.orderid = orderid;
        this.productID = productID;
        this.amount = amount;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

