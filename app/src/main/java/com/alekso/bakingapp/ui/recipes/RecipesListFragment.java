package com.alekso.bakingapp.ui.recipes;

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
import com.alekso.bakingapp.data.DataRepository;

/**
 * Created by alekso on 17/03/2018.
 */

public class RecipesListFragment extends Fragment {
    public static final String TAG = RecipesListFragment.class.getSimpleName();

    public RecipesListFragment() {
        // do nothing
    }

    public static RecipesListFragment newInstance() {
        return new RecipesListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final boolean isTwoPane = ((MainActivity) getActivity()).isTwoPane;

        final View v = inflater.inflate(R.layout.fragment_recipes_list, container, false);
        final RecyclerView recyclerView = v.findViewById(R.id.list);
        final RecipesAdapter adapter = new RecipesAdapter(
                DataRepository.getInstance().getAllRecipes(),
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
