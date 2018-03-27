package com.alekso.bakingapp.ui.steps;

import android.os.Bundle;

import com.alekso.bakingapp.BaseActivity;
import com.alekso.bakingapp.R;
import com.alekso.bakingapp.ui.step.RecipeStepFragment;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepsListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int recipeId = -1;

        if (getIntent().getExtras() != null) {
            recipeId = getIntent().getExtras().getInt("recipeId");
        }

        RecipeStepsListFragment listFragment = RecipeStepsListFragment.newInstance(recipeId);
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
