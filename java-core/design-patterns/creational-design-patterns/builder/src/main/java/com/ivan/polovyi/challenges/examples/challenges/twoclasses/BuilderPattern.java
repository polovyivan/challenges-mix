package com.ivan.polovyi.challenges.examples.challenges.twoclasses;

import java.util.List;

/*
    used mainly when constructor has to many parameters or many overloaded constructors
     getters are not part of the pattern, but some times is allowed
     */
public class BuilderPattern {
    private String species;
    private int age;
    private List<String> favoriteFoods;


    public BuilderPattern setSpecies(String species) {
        this.species = species;
        return this;
    }

    public BuilderPattern setAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderPattern setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal build() {
        return new Animal(species, age, favoriteFoods);
    }
}
