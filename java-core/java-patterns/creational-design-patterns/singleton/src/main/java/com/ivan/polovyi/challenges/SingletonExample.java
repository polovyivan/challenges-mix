package com.ivan.polovyi.challenges;

public class SingletonExample {

    private SingletonExample() {

    }
    private static final SingletonExample instance = new SingletonExample();

    public static SingletonExample getInstance() {
        return instance;
    }

}
