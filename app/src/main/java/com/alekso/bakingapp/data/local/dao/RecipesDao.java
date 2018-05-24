package com.alekso.bakingapp.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.List;

@Dao
public interface RecipesDao {

    @Query("SELECT * FROM recipes")
    LiveData<List<RecipeEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RecipeEntity> recipes);

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    LiveData<RecipeEntity> load(int recipeId);

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    RecipeEntity loadProductSync(int recipeId);
}