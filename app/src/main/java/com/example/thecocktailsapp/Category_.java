package com.example.thecocktailsapp;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Category_ {

    @SerializedName("strCategory")
    private String categoryName;

    /**
     * Getters & Setters
     */

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @NonNull
    @Override
    public String toString() {
        return categoryName;
    }
}
