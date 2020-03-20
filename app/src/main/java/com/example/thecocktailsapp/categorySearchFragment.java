package com.example.thecocktailsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class categorySearchFragment extends Fragment implements View.OnClickListener {

    Button btnSearch;
    Spinner spinnerCategory;

    private ArrayList<Drink_> drinks;
    private ArrayList<Category_> categories;
    String categoryName;

    DataServices service;

    private RecyclerView recyclerView;
    //    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private NavController navController;


    public categorySearchFragment() {
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
        return inflater.inflate(R.layout.fragment_category_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        spinnerCategory = (Spinner) getActivity().findViewById(R.id.spinner_category);
        btnSearch = getActivity().findViewById(R.id.button_search_category);

        btnSearch.setOnClickListener(this);

        getAllCategories();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_search_category) {
            btnSearchClick(v);
        }
    }

    private void btnSearchClick(View v) {

        Category_ category = (Category_) spinnerCategory.getSelectedItem();
        categoryName = category.getCategoryName();

        service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);

        Call<Drink> call = service.filterDrinks(categoryName, null);

        call.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity().getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Drink drinkList = response.body();
                    drinks = new ArrayList<>(drinkList.getDrinkList());

                    fillRecyclerView();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillRecyclerView() {
        recyclerView = getActivity().findViewById(R.id.recycler_view_drinks);
        recyclerLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerAdapter = new RecyclerAdapter(drinks);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(getActivity().getApplicationContext(), drinks.get(position).getName(), Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putParcelable("drink", drinks.get(position));
                navController.navigate(R.id.drinkFragment, bundle);
            }
        });
    }

    private void getAllCategories() {

        service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);

        Call<Category> call = service.getAllCategories();

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                try {
                    Category categoryList = response.body();
                    categories = new ArrayList<>(categoryList.getCategoryList());

                    ArrayAdapter<Category_> ingredientAdapter = new ArrayAdapter<Category_>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_item, categories);

                    ingredientAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinnerCategory.setAdapter(ingredientAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
            }
        });
    }
}

