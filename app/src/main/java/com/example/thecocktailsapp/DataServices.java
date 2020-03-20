package com.example.thecocktailsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataServices {

    @GET("filter.php?a=Non_Alcoholic")
    Call<Drink> getDrinks();

    //    @GET("search.php?s=margarita")
    @GET("search.php")
    Call<Drink> searchDrinks(
            @Query("s") String byName,
            @Query("f") String byFirstLetter,
            @Query("i") String byIngredientName
    );

    @GET("list.php?i=list")
    Call<SearchIngredient> getAllIngredients();

    @GET("list.php?c=list")
    Call<Category> getAllCategories();

    @GET("filter.php")
    Call<Drink> filterDrinks(
            @Query("c") String categoryName,
            @Query("i") String ingredientName
    );

    @GET("lookup.php")
    Call<Drink> getDrinkDetails(@Query("i") String drinkID);

}
