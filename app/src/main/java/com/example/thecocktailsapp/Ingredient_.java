package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

public class Ingredient_ {


    @SerializedName("idIngredient")
    private String ID;

    @SerializedName("strIngredient")
    private String name;

    @SerializedName("strDescription")
    private String description;

    @SerializedName("strType")
    private String type;

    @SerializedName("strAlcohol")
    private String alcohol;

    @SerializedName("strABV")
    private String ABV;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getABV() {
        return ABV;
    }

    public void setABV(String ABV) {
        this.ABV = ABV;
    }
}
