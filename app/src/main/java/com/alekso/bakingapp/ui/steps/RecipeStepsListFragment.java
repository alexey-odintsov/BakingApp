package com.alekso.bakingapp.ui.steps;

import android.os.Bundle;
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
    private int recipeId;

    public RecipeStepsListFragment() {

    }

    public static RecipeStepsListFragment newInstance(int recipeId) {
        final RecipeStepsListFragment fragment = new RecipeStepsListFragment();
        Bundle params = new Bundle();
        params.putInt("recipeId", recipeId);
        fragment.setArguments(params);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recipe_steps_list, container, false);

        if (getArguments() != null) {
            recipeId = getArguments().getInt("recipeId");
        }
        final TextView tvTitle = v.findViewById(R.id.tv_title);
        tvTitle.setText("RECIPE #" + recipeId + " STEPS");
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showRecipeStep(recipeId, 0);
            }
        });
        return v;
    }
}
