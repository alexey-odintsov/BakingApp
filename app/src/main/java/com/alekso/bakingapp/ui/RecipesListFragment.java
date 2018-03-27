package com.alekso.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alekso.bakingapp.BaseActivity;
import com.alekso.bakingapp.R;

/**
 * Created by alekso on 17/03/2018.
 */

public class RecipesListFragment extends Fragment {

    public RecipesListFragment() {
        // do nothing
    }

    public static RecipesListFragment newInstance() {
        final RecipesListFragment fragment = new RecipesListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recipes_list, container, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getActivity()).showRecipeSteps(12);
            }
        });
        return v;
    }
}
