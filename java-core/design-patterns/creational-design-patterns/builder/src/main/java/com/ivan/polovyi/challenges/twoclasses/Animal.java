package com.ivan.polovyi.challenges.twoclasses;

import java.util.List;

public class Animal {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }


    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFoods() {
        return favoriteFoods;
    }
}
