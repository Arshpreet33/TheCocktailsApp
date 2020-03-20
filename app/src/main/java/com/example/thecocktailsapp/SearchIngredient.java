package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchIngredient {

    @SerializedName("drinks")
    private List<SearchIngredient_> ingredientList = null;

    /**
     * Getters & Setters
     */

    public List<SearchIngredient_> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<SearchIngredient_> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
