package com.alekso.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.alekso.bakingapp.ui.step.RecipeStepFragment;
import com.alekso.bakingapp.ui.step.RecipeStepActivity;
import com.alekso.bakingapp.ui.steps.RecipeStepsListActivity;

/**
 * Base activity that shares same base layout with NavigationDrawer
 * <p>
 * Created by alekso on 24/03/2018.
 */

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public boolean isTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        determinePaneMode();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void determinePaneMode() {
        FrameLayout detailFragment = findViewById(R.id.detail);
        if (detailFragment != null) {
            isTwoPane = true;
        }
    }

    public void showRecipeSteps(int recipeId) {
        Intent intent = new Intent(this, RecipeStepsListActivity.class);
        intent.putExtra("recipeId", recipeId);
        startActivity(intent);
    }

    public void showRecipeStep(int recipeId, int stepId) {
        if (isTwoPane) {
            RecipeStepFragment recipeStepFragment = RecipeStepFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail, recipeStepFragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, RecipeStepActivity.class);
            intent.putExtra("recipeId", recipeId);
            intent.putExtra("stepId", stepId);
            startActivity(intent);
        }
    }
}
