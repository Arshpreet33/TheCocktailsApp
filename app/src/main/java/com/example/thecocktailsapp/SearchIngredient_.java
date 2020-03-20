package com.example.thecocktailsapp;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class SearchIngredient_ {

    @SerializedName("strIngredient1")
    private String ingredientName;

    /**
     * Getters & Setters
     */

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @NonNull
    @Override
    public String toString() {
        return ingredientName;
    }
}
