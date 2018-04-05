package com.alekso.bakingapp.model;

/**
 * Created by alekso on 17/03/2018.
 */

public class Step {
    public int id;
    public String shortDescription;
    private String videoUrl;
    private String thumbnailUrl;

    public Step(int id, String shortDescription) {
        this.id = id;
        this.shortDescription = shortDescription;
    }
}
