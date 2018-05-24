package com.alekso.bakingapp.ui.recipes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

import com.alekso.bakingapp.MainActivity;
import com.alekso.bakingapp.R;
import com.alekso.bakingapp.model.Recipe;

import java.util.List;

/**
 * Created by alekso on 17/03/2018.
 */

public class RecipesListFragment extends Fragment {
    public static final String TAG = RecipesListFragment.class.getSimpleName();

    private RecipesAdapter adapter;

    public RecipesListFragment() {
        // do nothing
    }

    @NonNull
    public static RecipesListFragment newInstance() {
        return new RecipesListFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecipesViewModel viewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);
        viewModel.getRecipes().observe(this, recipes -> adapter.setItems(recipes));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final boolean isTwoPane = ((MainActivity) getActivity()).isTwoPane;

        final View v = inflater.inflate(R.layout.fragment_recipes_list, container, false);
        final RecyclerView recyclerView = v.findViewById(R.id.list);
        adapter = new RecipesAdapter(
                recipeId -> {
                    Log.d(TAG, "onItemClick #" + recipeId);
                    ((MainActivity) getActivity()).showRecipeSteps(recipeId);
                });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(isTwoPane ?
                new GridLayoutManager(getContext(), 3) :
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return v;
    }
}