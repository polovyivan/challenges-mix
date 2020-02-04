package com.ivan.polovyi.challenges;

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
