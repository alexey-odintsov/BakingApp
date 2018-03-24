package com.alekso.bakingapp;

import android.os.Bundle;

import com.alekso.bakingapp.ui.RecipeStepFragment;
import com.alekso.bakingapp.ui.RecipeStepsListFragment;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepsListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipeStepsListFragment listFragment = RecipeStepsListFragment.newInstance();
        if (isTwoPane) {
            RecipeStepFragment detailFragment = RecipeStepFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list, listFragment)
                    .replace(R.id.detail, detailFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, listFragment).commit();
        }
    }
}
