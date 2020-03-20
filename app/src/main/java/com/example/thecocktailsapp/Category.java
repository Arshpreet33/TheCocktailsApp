package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

    @SerializedName("drinks")
    private List<Category_> categoryList = null;

    /**
     * Getters & Setters
     */

    public List<Category_> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category_> categoryList) {
        this.categoryList = categoryList;
    }
}
