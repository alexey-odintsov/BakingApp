package com.alekso.bakingapp.ui.recipes;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.alekso.bakingapp.App;
import com.alekso.bakingapp.model.Recipe;

import java.util.List;

public class RecipesViewModel extends AndroidViewModel {
    @NonNull
    private MediatorLiveData<List<Recipe>> observableRecipes;

    public RecipesViewModel(@NonNull Application application) {
        super(application);

        observableRecipes = new MediatorLiveData<>();
        observableRecipes.setValue(null);

        final LiveData<List<Recipe>> recipes = ((App) application).getRepository().getAllRecipes();
        observableRecipes.addSource(recipes, updatedRecipes -> observableRecipes.setValue(updatedRecipes));
    }

    @NonNull
    LiveData<List<Recipe>> getRecipes() {
        return observableRecipes;
    }
}
