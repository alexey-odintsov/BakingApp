package com.alekso.bakingapp;

import android.os.Bundle;

import com.alekso.bakingapp.ui.RecipeStepFragment;

/**
 * Created by alekso on 24/03/2018.
 */

public class StepActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipeStepFragment stepFragment = RecipeStepFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, stepFragment).commit();
    }
}
