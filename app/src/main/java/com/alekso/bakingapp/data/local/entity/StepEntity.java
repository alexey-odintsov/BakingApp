package com.alekso.bakingapp.data.local.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.Nullable;

@Entity(tableName = "steps", primaryKeys = {"recipeId", "stepId"})
public class StepEntity {
    private int recipeId;
    private int stepId;
    private String shortDescription;
    @Nullable
    private String videoUrl;
    private String thumbnailUrl;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Nullable
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(@Nullable String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
