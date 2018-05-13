package com.alekso.bakingapp.data;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alekso.bakingapp.data.local.AbsDatabase;
import com.alekso.bakingapp.data.local.entity.RecipeEntity;
import com.alekso.bakingapp.model.Recipe;
import com.alekso.bakingapp.model.RecipeBuilder;
import com.alekso.bakingapp.model.Step;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    @Nullable
    private static DataRepository instance;
    private final AbsDatabase database;


    private DataRepository(@NonNull final AbsDatabase database) {
        this.database = database;
    }

    @NonNull
    public static DataRepository getInstance(@NonNull final AbsDatabase database) {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository(database);
                }
            }
        }
        return instance;
    }

    @NonNull
    public List<Recipe> getAllRecipes() {
        List<RecipeEntity> entities = database.recipesDao().loadAll();
        List<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            recipes.add(new RecipeBuilder(entities.get(i)).build());
        }
        return recipes;
    }

    @NonNull
    public List<Step> getRecipeSteps() {
        ArrayList<Step> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            items.add(new Step(i, "step #" + i));
        }

        return items;
    }
}
