package com.smartpantry.activities;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartpantry.R;

public abstract class BaseBottomNavActivity extends AppCompatActivity {

    protected void setupBottomNav(BottomNavigationView bottomNav, @IdRes int selectedItemId) {
        bottomNav.setSelectedItemId(selectedItemId);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == selectedItemId) {
                return true;
            }

            if (id == R.id.nav_home) {
                navigateTo(HomeActivity.class);
                return true;
            }

            if (id == R.id.nav_add_item) {
                navigateTo(AddItemActivity.class);
                return true;
            }

            if (id == R.id.nav_suggestions) {
                navigateTo(SuggestionsActivity.class);
                return true;
            }

            if (id == R.id.nav_profile) {
                navigateTo(ProfileActivity.class);
                return true;
            }

            return false;
        });
    }

    private void navigateTo(Class<? extends Activity> target) {
        Intent intent = new Intent(this, target);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}

