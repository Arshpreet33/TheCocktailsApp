package com.example.thecocktailsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Drink {

    @SerializedName("drinks")
    private List<Drink_> drinkList = null;

    /**
     * Getters & Setters
     */

    public List<Drink_> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink_> drinkList) {
        this.drinkList = drinkList;
    }
}
