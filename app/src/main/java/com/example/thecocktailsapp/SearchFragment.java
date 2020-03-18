package com.example.thecocktailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment implements View.OnClickListener {

    TextView textDisplay;
    EditText txtSearchDrink;
    Button btnSearch;
    DataServices service;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textDisplay = getActivity().findViewById(R.id.text_search);
        txtSearchDrink = getActivity().findViewById(R.id.text_search_drink);
        btnSearch = getActivity().findViewById(R.id.button_search);

        btnSearch.setOnClickListener(this);
        textDisplay.setText("");


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_search) {
            btnSearchClick();
        }
    }

    private void btnSearchClick() {

        String searchedText = txtSearchDrink.getText().toString();

        service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);

        Call<Drink> call = service.searchDrinks(searchedText,null,null);

        call.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {
                if (!response.isSuccessful()) {
                    textDisplay.setText(response.code());
                    return;
                }

                try {
                    Drink drinkList = response.body();
                    List<Drink_> drinks = new ArrayList<>(drinkList.getDrinkList());

                    for (Drink_ drink : drinks) {
                        String content = "";
                        content += "ID:        " + drink.getID() + "\n";
                        content += "Name:      " + drink.getName() + "\n";
                        content += "Category:  " + drink.getCategory() + "\n";
                        content += "Alcoholic: " + drink.getAlcoholic() + "\n";
                        content += "Glass:     " + drink.getGlass() + "\n";
                        content += "IBA:       " + drink.getIBA() + "\n";
                        content += "Steps:     " + drink.getSteps() + "\n";

                        textDisplay.append(content);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                textDisplay.setText(t.getMessage());
            }
        });
    }

}
