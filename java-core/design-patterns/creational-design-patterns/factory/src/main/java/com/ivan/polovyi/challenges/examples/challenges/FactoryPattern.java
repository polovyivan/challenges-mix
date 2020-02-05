package com.ivan.polovyi.challenges.examples.challenges;

public class FactoryPattern {


    public static Food getFood(String animalName) {

        switch (animalName) {
            case "zebra":
                return new Hay(100);
            case "rabbit":
                return new Pellets(5);
            case "goat":
                return new Pellets(30);
            case "polar bear":
                return new Fish(30);
        }
        throw new UnsupportedOperationException("Unsupported animal " + animalName);
    }
}
