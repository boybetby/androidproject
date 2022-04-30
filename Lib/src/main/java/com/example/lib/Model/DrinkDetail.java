package com.example.lib.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinkDetail {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("drink")
    @Expose
    private DrinkModel drink = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public DrinkModel getDrink() {
        return drink;
    }

    public void setDrinks(DrinkModel drink) {
        this.drink = drink;
    }

}