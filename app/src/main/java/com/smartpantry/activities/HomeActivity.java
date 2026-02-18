package com.smartpantry.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartpantry.R;
import com.smartpantry.adapters.PantryAdapter;
import com.smartpantry.models.PantryItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseBottomNavActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        setupBottomNav(bottomNav, R.id.nav_home);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PantryAdapter(seedItems()));
    }

    private List<PantryItem> seedItems() {
        List<PantryItem> items = new ArrayList<>();
        items.add(new PantryItem("Rice", 2, "kg", "Pantry"));
        items.add(new PantryItem("Pasta", 3, "packs", "Pantry"));
        items.add(new PantryItem("Olive Oil", 1, "bottle", "Kitchen"));
        items.add(new PantryItem("Canned Beans", 6, "cans", "Pantry"));
        return items;
    }
}

