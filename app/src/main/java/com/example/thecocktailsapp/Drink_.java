package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

public class Drink_ {

    @SerializedName("idDrink")
    private String ID;

    @SerializedName("strDrink")
    private String name;

    @SerializedName("strDrinkThumb")
    private String imageUrl;

    @SerializedName("strCategory")
    private String category;

    @SerializedName("strAlcoholic")
    private String alcoholic;

    @SerializedName("strGlass")
    private String glass;

    @SerializedName("strInstructions")
    private String steps;

    @SerializedName("strIBA")
    private String IBA;

    /**
     * Getters & Setters
     */

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getIBA() {
        return IBA;
    }

    public void setIBA(String IBA) {
        this.IBA = IBA;
    }
}
