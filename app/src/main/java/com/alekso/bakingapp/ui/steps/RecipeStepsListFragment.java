package com.alekso.bakingapp.ui.steps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekso.bakingapp.App;
import com.alekso.bakingapp.MainActivity;
import com.alekso.bakingapp.R;
import com.alekso.bakingapp.data.DataRepository;
import com.alekso.bakingapp.ui.recipes.RecipesAdapter;
import com.alekso.bakingapp.ui.step.RecipeStepsAdapter;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeStepsListFragment extends Fragment {
    public static final String TAG = RecipeStepsListFragment.class.getSimpleName();

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
        final boolean isTwoPane = ((MainActivity) getActivity()).isTwoPane;

        final View view = inflater.inflate(R.layout.fragment_recipe_steps_list, container, false);

        if (getArguments() != null) {
            recipeId = getArguments().getInt(PARAM_RECIPE_ID);
        }
        final TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("RECIPE #" + recipeId + " STEPS");

        final RecyclerView recyclerView = view.findViewById(R.id.list);
        final RecipeStepsAdapter adapter = new RecipeStepsAdapter(recipeId,
                ((App) getActivity().getApplication()).getRepository().getRecipeSteps(),
                (recipeId, stepId) -> {
                    Log.d(TAG, "onItemClick #" + recipeId);
                    ((MainActivity) getActivity()).showRecipeStep(recipeId, stepId);
                });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(isTwoPane ?
                new GridLayoutManager(getContext(), 3) :
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
}
