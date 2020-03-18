package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredient {

    @SerializedName("ingredients")
    private List<Ingredient_> ingredientList = null;

    /**
     * Getters & Setters
     */

    public List<Ingredient_> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient_> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
