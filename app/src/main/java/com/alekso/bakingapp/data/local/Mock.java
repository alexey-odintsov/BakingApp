package com.alekso.bakingapp.data.local;

import android.support.annotation.NonNull;

import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mock {

    private static final String[] NAMES = {"Milk", "Bread", "Coffe", "Apple", "Eggs", "Syrup", "Chocolate", "Pork", "Water melon", "Lemon"};
    private static final String[] TYPE = {"soup", "cookies", "cereal", "sandwich", "salad"};

    @NonNull
    public static List<RecipeEntity> generate(int n) {
        final List<RecipeEntity> result = new ArrayList<>();
        final Random random = new Random();

        for (int i = 0; i < n; i++) {
            RecipeEntity recipe = new RecipeEntity();
            recipe.setId(i);
            recipe.setName(NAMES[random.nextInt(NAMES.length - 1)] + " " + TYPE[random.nextInt(TYPE.length - 1)]);
            recipe.setServings(random.nextInt(12));
            recipe.setImage("https://pic.me/?id=" + random.nextInt());
            result.add(recipe);
        }

        return result;
    }
}
