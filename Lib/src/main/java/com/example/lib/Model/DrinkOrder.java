
package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrinkOrder implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("drinkName")
    @Expose
    private String drinkName;
    @SerializedName("singlePrice")
    @Expose
    private Double defaultPrice = null;
    @SerializedName("size")
    @Expose
    private String size = "S";
    @SerializedName("quantity")
    @Expose
    private int quantity;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DrinkOrder() {}

    public DrinkOrder(String id, String drinkName, Double defaultPrice, String size, int quantity) {
        this.id = id;
        this.drinkName = drinkName;
        this.defaultPrice = defaultPrice;
        this.size = size;
        this.quantity = quantity;
    }
}

