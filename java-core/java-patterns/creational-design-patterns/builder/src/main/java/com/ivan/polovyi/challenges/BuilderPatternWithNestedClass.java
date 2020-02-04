package com.ivan.polovyi.challenges;

import java.util.List;

public class BuilderPatternWithNestedClass {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    private BuilderPatternWithNestedClass(
            BuilderPatternWithNestedClassBuilder builderPatternWithNestedClassBuilder) {
        this.species = builderPatternWithNestedClassBuilder.species;
        this.age = builderPatternWithNestedClassBuilder.age; // optional
        this.favoriteFoods = builderPatternWithNestedClassBuilder.favoriteFoods;

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


    public static class BuilderPatternWithNestedClassBuilder {
        private String species;
        private int age;
        private List<String> favoriteFoods;


        public BuilderPatternWithNestedClassBuilder(String species, List<String> favoriteFoods) {
            this.species = species;
            this.favoriteFoods = favoriteFoods;
        }


        public BuilderPatternWithNestedClassBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public BuilderPatternWithNestedClassBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public BuilderPatternWithNestedClassBuilder setFavoriteFoods(List<String> favoriteFoods) {
            this.favoriteFoods = favoriteFoods;
            return this;
        }

        public BuilderPatternWithNestedClass build() {
            return new BuilderPatternWithNestedClass(this);
        }
    }


}
