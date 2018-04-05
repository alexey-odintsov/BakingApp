package com.alekso.bakingapp.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alekso.bakingapp.model.Recipe;
import com.alekso.bakingapp.model.Step;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    @Nullable
    private static DataRepository instance;

    @NonNull
    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    @NonNull
    public List<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            recipes.add(new Recipe(i, "recipe #" + i));
        }

        return recipes;
    }

    public List<Step> getRecipeSteps() {
        ArrayList<Step> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            items.add(new Step(i, "step #" + i));
        }

        return items;
    }
}
