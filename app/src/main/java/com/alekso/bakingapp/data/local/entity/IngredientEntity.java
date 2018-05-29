package com.alekso.bakingapp.data.local.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "ingredients", primaryKeys = {"recipeId", "name"})
public class IngredientEntity {
    private int recipeId;
    @NonNull
    private String name;
    private String measure;
    private float quantity;

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
