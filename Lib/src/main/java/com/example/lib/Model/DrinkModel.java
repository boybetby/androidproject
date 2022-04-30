
package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrinkModel implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("drinkName")
    @Expose
    private String drinkName;
    @SerializedName("drinkImage")
    @Expose
    private String drinkImage;
    @SerializedName("defaultPrice")
    @Expose
    private List<Integer> defaultPrice = null;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("sale")
    @Expose
    private Integer sale;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("ingredients")
    @Expose
    private List<Object> ingredients = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkImage() {
        return drinkImage;
    }

    public void setDrinkImage(String drinkImage) {
        this.drinkImage = drinkImage;
    }

    public List<Integer> getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(List<Integer> defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Object> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public DrinkModel(String id, String drinkName, String drinkImage, List<Integer> defaultPrice, String category, String description) {
        this.id = id;
        this.drinkName = drinkName;
        this.drinkImage = drinkImage;
        this.defaultPrice = defaultPrice;
        this.category = category;
        this.description = description;
    }
}

