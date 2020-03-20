package com.example.thecocktailsapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
    }

    public void setupNavigation() {
        toolbar = findViewById(R.id.toolbar_custom);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setCheckable(true);
        drawerLayout.closeDrawers();

        int menuID = menuItem.getItemId();

        switch (menuID) {
            case R.id.menu_item_home:
//                Toast.makeText(getApplicationContext(), "Home Item Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.homeFragment);
                break;
            case R.id.menu_item_search:
//                Toast.makeText(getApplicationContext(), "Search Item Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.searchFragment);
                break;
            case R.id.menu_item_search_category:
//                Toast.makeText(getApplicationContext(), "Search Item Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.categorySearchFragment);
                break;
            case R.id.menu_item_search_ingredient:
//                Toast.makeText(getApplicationContext(), "Drink Item Clicked!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.ingredientSearchFragment);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Incorrect Menu Item Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }
}
