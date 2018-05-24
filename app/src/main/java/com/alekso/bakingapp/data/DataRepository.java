package com.alekso.bakingapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
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
    @NonNull
    private final AbsDatabase database;
    @NonNull
    private MediatorLiveData<List<RecipeEntity>> observableRecipes;

    private DataRepository(@NonNull final AbsDatabase database) {
        this.database = database;

        observableRecipes = new MediatorLiveData<>();
        observableRecipes.addSource(database.recipesDao().loadAll(), recipeEntities -> {
            if (database.isCreated().getValue() != null) {
                observableRecipes.postValue(recipeEntities);
            }
        });
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
    public LiveData<List<Recipe>> getAllRecipes() {
        return Transformations.map(observableRecipes, RecipeBuilder::convert);
    }

    public LiveData<Recipe> getRecipe(int id) {
        return Transformations.map(database.recipesDao().load(id), entity -> new RecipeBuilder(entity).build());
    }

    @NonNull
    public List<Step> getRecipeSteps() {
        final ArrayList<Step> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            items.add(new Step(i, "step #" + i));
        }

        return items;
    }
}
