package com.alekso.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alekso.bakingapp.R;

/**
 * Created by alekso on 24/03/2018.
 */

public class RecipeDetailFragment extends Fragment {

    public RecipeDetailFragment() {

    }

    public static RecipeDetailFragment newInstance() {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        return v;
    }
}
