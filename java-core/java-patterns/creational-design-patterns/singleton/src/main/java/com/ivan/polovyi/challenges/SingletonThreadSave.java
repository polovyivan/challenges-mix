package com.ivan.polovyi.challenges;

public class SingletonThreadSave {

    private int quantity = 0;

    private SingletonThreadSave() {
    }

    private static final SingletonThreadSave instance = new SingletonThreadSave();

    public static SingletonThreadSave getInstance() {

        return instance;
    }

    public synchronized void addQuantity(int amount) {
        quantity += amount;
    }

    public synchronized boolean substract(int amount) {
        if (quantity < amount) return false;
        quantity += amount;
        return true;
    }

    public synchronized int getQuantity() {
        return quantity;
    }

}
