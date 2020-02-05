package com.ivan.polovyi.challenges.examples.challenges;

public class Fish extends Food {


    public Fish(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Fish eaten " + getQuantity());
    }
}
