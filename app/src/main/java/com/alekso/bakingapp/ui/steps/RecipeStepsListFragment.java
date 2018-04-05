package com.alekso.bakingapp.ui.steps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekso.bakingapp.MainActivity;
import com.alekso.bakingapp.R;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepsListFragment extends Fragment {

    public static final String PARAM_RECIPE_ID = "recipeId";

    private int recipeId;

    public RecipeStepsListFragment() {

    }

    public static RecipeStepsListFragment newInstance(int recipeId) {
        final RecipeStepsListFragment fragment = new RecipeStepsListFragment();
        Bundle params = new Bundle();
        params.putInt(PARAM_RECIPE_ID, recipeId);
        fragment.setArguments(params);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recipe_steps_list, container, false);

        if (getArguments() != null) {
            recipeId = getArguments().getInt(PARAM_RECIPE_ID);
        }
        final TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("RECIPE #" + recipeId + " STEPS");
        view.setOnClickListener(v -> ((MainActivity) getActivity()).showRecipeStep(recipeId, 0));
        return view;
    }
}
