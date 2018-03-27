package com.alekso.bakingapp.ui.step;

import android.os.Bundle;

import com.alekso.bakingapp.BaseActivity;
import com.alekso.bakingapp.R;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipeStepFragment stepFragment = RecipeStepFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, stepFragment).commit();
    }
}
