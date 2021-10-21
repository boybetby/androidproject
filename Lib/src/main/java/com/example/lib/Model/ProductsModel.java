package com.example.lib.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductsModel implements Serializable {

    @SerializedName("OrderDetails")
    @Expose
    private List<Object> orderDetails = null;
    @SerializedName("productID")
    @Expose
    private Integer productID;
    @SerializedName("productname")
    @Expose
    private String productname;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("image")
    @Expose
    private String image;

    public List<Object> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Object> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public ProductsModel() {
    }

    public ProductsModel(Integer productID, String productname, String description, Double price, Integer category, String image) {
        this.productID = productID;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }
}
