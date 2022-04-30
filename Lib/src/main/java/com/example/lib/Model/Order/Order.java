package com.example.lib.Model.Order;

import com.example.lib.Model.DrinkModel;
import com.example.lib.Model.DrinkOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {

    @SerializedName("customerName")
    @Expose
    String customerName;
    @SerializedName("customer")
    @Expose
    String customer;
    @SerializedName("drinks")
    @Expose
    ArrayList<DrinkOrder> drinks;
    @SerializedName("totalPrice")
    @Expose
    Double totalPrice;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("customerAddress")
    @Expose
    String customerAddress;

    public Order() {}

    public Order(String customerName, String customer, ArrayList<DrinkOrder> drinks, Double totalPrice, String type, String customerAddress) {
        this.customerName = customerName;
        this.customer = customer;
        this.drinks = drinks;
        this.totalPrice = totalPrice;
        this.type = type;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<DrinkOrder> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<DrinkOrder> drinks) {
        this.drinks = drinks;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}



