package com.alekso.bakingapp.model;

import android.support.annotation.StringRes;

import com.alekso.bakingapp.R;

/**
 * Created by alekso on 17/03/2018.
 */

public class Ingredient {
    private String name;
    private TYPE measure;
    private float quantity;

    public enum TYPE {
        CUP(R.string.ingredient_type_cup, R.string.ingredient_type_cup_abbr),
        TBLSP(R.string.ingredient_type_tblsp, R.string.ingredient_type_tblsp_abbr),
        TSP(R.string.ingredient_type_tsp, R.string.ingredient_type_tsp_abbr),
        K(R.string.ingredient_type_k, R.string.ingredient_type_k_abbr),
        G(R.string.ingredient_type_g, R.string.ingredient_type_g_abbr),
        OZ(R.string.ingredient_type_oz, R.string.ingredient_type_oz_abbr),
        UNIT(R.string.ingredient_type_unit, R.string.ingredient_type_unit_abbr);

        @StringRes
        private int nameResId;
        @StringRes
        private int abbrResId;

        TYPE(@StringRes int nameResId, @StringRes int abbrResId) {
            this.nameResId = nameResId;
            this.abbrResId = abbrResId;
        }
    }
}
