package com.alekso.bakingapp.model;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

public class RecipeBuilder {
    private Recipe recipe;

    public RecipeBuilder(RecipeEntity entity) {
        recipe = new Recipe(entity.getId(), entity.getName());
        recipe.servings = entity.getServings();
        recipe.image = entity.getImage();
    }

    public Recipe build() {
        return recipe;
    }
}
