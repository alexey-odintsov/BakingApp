package com.alekso.bakingapp.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeBuilder {
    @NonNull
    private Recipe recipe;

    public RecipeBuilder(RecipeEntity entity) {
        recipe = new Recipe(entity.getId(), entity.getName());
        recipe.servings = entity.getServings();
        recipe.image = entity.getImage();
    }

    @NonNull
    public static List<Recipe> convert(@Nullable List<RecipeEntity> entities) {
        List<Recipe> recipes = new ArrayList<>();
        if (entities != null) {
            for (RecipeEntity entity : entities) {
                recipes.add(new RecipeBuilder(entity).build());
            }
        }
        return recipes;
    }

    @NonNull
    public Recipe build() {
        return recipe;
    }
}
