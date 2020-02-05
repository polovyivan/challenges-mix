package com.ivan.polovyi.challenges.examples.challenges;

public abstract class Food {

    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public abstract void consumed();

    public int getQuantity() {
        return quantity;
    }
}
