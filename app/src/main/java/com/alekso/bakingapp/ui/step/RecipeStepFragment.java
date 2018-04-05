package com.alekso.bakingapp.ui.step;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekso.bakingapp.R;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepFragment extends Fragment {
    private int recipeId = -1;
    private int stepId = -1;

    public RecipeStepFragment() {

    }

    public static RecipeStepFragment newInstance(int recipeId, int stepId) {
        final RecipeStepFragment fragment = new RecipeStepFragment();
        Bundle args = new Bundle();
        args.putInt("recipeId", recipeId);
        args.putInt("stepId", stepId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recipe_step, container, false);

        if (getArguments() != null) {
            recipeId = getArguments().getInt("recipeId");
            stepId = getArguments().getInt("stepId");
        }

        TextView tvMessage = v.findViewById(R.id.tv_message);
        tvMessage.setText("Recipe " + recipeId + " step " + stepId);
        return v;
    }

}
