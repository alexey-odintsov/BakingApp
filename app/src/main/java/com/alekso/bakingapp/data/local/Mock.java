package com.alekso.bakingapp.data.local;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mock {

    public static final String[] NAMES = {"Milk", "Bread", "Coffe", "Apple", "Eggs", "Syrup", "Chocolate", "Pork", "Water melon", "Lemon"};
    public static final String[] TYPE = {"soup", "cookies", "cereal", "sandwich", "salad"};

    public static List<RecipeEntity> generate(int n) {
        List<RecipeEntity> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            RecipeEntity recipe = new RecipeEntity();
            recipe.setName(NAMES[random.nextInt(NAMES.length -1)] + " " + TYPE[random.nextInt(TYPE.length - 1)]);
            recipe.setServings(random.nextInt(12));
            recipe.setImage("https://pic.me/?id=" + random.nextInt());
            result.add(recipe);
        }

        return result;
    }
}
