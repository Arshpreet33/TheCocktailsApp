package com.example.thecocktailsapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Drink_ implements Parcelable {

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

    protected Drink_(Parcel in) {
        ID = in.readString();
        name = in.readString();
        imageUrl = in.readString();
        category = in.readString();
        alcoholic = in.readString();
        glass = in.readString();
        steps = in.readString();
        IBA = in.readString();
    }

    public static final Creator<Drink_> CREATOR = new Creator<Drink_>() {
        @Override
        public Drink_ createFromParcel(Parcel in) {
            return new Drink_(in);
        }

        @Override
        public Drink_[] newArray(int size) {
            return new Drink_[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeString(category);
        dest.writeString(alcoholic);
        dest.writeString(glass);
        dest.writeString(steps);
        dest.writeString(IBA);
    }
}
