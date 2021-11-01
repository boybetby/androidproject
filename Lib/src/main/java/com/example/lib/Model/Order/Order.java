package com.example.lib.Model.Order;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    String OrderID;
    String Name;
    String Email;
    String PhoneNumber;
    String Address;
    Double TotalPrice;
    String Date;

    public Order() {
    }

    public Order(String orderID, String name, String email, String phoneNumber, String address, Double totalPrice, String date) {
        OrderID = orderID;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Address = address;
        TotalPrice = totalPrice;
        Date = date;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}



