package com.example.thecocktailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.squareup.picasso.Picasso;

public class DrinkFragment extends Fragment {

    TextView drinkName, drinkCategory, drinkAlcoholic, drinkSteps;
    ImageView drinkImage;

    Drink_ drink;

    private NavController navController;

    public DrinkFragment() {
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
        return inflater.inflate(R.layout.fragment_drink, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        drink = getArguments().getParcelable("drink");

        drinkName = getActivity().findViewById(R.id.drink_name);
        drinkCategory = getActivity().findViewById(R.id.drink_category);
        drinkAlcoholic = getActivity().findViewById(R.id.drink_alcoholic);
        drinkSteps = getActivity().findViewById(R.id.drink_steps);
        drinkImage = getActivity().findViewById(R.id.drink_image);

        fillData();
    }

    private void fillData() {
        drinkName.setText(drink.getName());
        drinkCategory.setText(drink.getCategory());
        drinkAlcoholic.setText(drink.getAlcoholic());
        drinkSteps.setText(drink.getSteps());

        Picasso.get().load(drink.getImageUrl()).into(drinkImage);

    }
}
