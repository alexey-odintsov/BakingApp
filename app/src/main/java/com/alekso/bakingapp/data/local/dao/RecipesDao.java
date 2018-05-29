package com.alekso.bakingapp.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.alekso.bakingapp.data.local.entity.IngredientEntity;
import com.alekso.bakingapp.data.local.entity.RecipeEntity;
import com.alekso.bakingapp.data.local.entity.StepEntity;

import java.util.List;

@Dao
public interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecipes(List<RecipeEntity> recipes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSteps(List<StepEntity> recipeSteps);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIngredients(List<IngredientEntity> ingredientEntities);

    @Query("SELECT * FROM recipes")
    LiveData<List<RecipeEntity>> loadAll();

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    LiveData<RecipeEntity> loadRecipes(int recipeId);

    @Query("SELECT * FROM steps WHERE recipeId = :recipeId")
    LiveData<List<StepEntity>> loadSteps(int recipeId);

    @Query("SELECT * FROM ingredients WHERE recipeId = :recipeId")
    LiveData<List<IngredientEntity>> loadIngredients(int recipeId);
}