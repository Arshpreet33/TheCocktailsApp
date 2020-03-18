package com.example.thecocktailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    TextView text;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Toast.makeText(getContext(), "oncreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        Toast.makeText(getContext(), "oncreateview", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text = getActivity().findViewById(R.id.text_home_fragment);
        text.setText("");
        DataServices service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);

        Call<Drink> call = service.getDrinks();

        call.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {
                if (!response.isSuccessful()) {
                    text.setText(response.code());
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

                        text.append(content);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }

}
