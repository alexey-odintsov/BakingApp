package com.alekso.bakingapp.model;

import java.util.List;
import java.util.Map;

/**
 * Created by alekso on 17/03/2018.
 */

public class Recipe {
    public int id;
    public String name;
    /**
     * Ingredient : quantity
     */
    private Map<Ingredient, Float> ingredients;
    private List<Step> steps;
    private int servings;
    private String image;

    public Recipe(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
