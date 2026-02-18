package com.smartpantry.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.smartpantry.R;

public class AddItemActivity extends BaseBottomNavActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        setupBottomNav(bottomNav, R.id.nav_add_item);

        TextInputEditText inputName = findViewById(R.id.inputName);
        TextInputEditText inputQuantity = findViewById(R.id.inputQuantity);
        TextInputEditText inputUnit = findViewById(R.id.inputUnit);
        MaterialButton buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String name = value(inputName);
            String qty = value(inputQuantity);
            String unit = value(inputUnit);

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter an item name", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Saved: " + name + " (" + qty + " " + unit + ")", Toast.LENGTH_SHORT).show();
        });
    }

    private String value(TextInputEditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }
}

