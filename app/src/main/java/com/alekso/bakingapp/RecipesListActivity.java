package com.alekso.bakingapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.alekso.bakingapp.ui.RecipeStepsListFragment;
import com.alekso.bakingapp.ui.RecipesListFragment;

public class RecipesListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipesListFragment listFragment = RecipesListFragment.newInstance();
        if (isTwoPane) {
            RecipeStepsListFragment detailFragment = RecipeStepsListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list, listFragment)
                    .replace(R.id.detail, detailFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, listFragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
