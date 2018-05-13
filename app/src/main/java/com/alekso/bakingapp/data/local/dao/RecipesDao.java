package com.alekso.bakingapp.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.List;

@Dao
public interface RecipesDao {
    @Query("SELECT * FROM recipes")
    List<RecipeEntity> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RecipeEntity> products);

    @Query("select * from recipes where id = :recipeId")
    RecipeEntity load(int recipeId);
}
