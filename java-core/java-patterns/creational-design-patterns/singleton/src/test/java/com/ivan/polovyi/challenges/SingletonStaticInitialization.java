package com.ivan.polovyi.challenges;

public class SingletonStaticInitialization {

    private static final SingletonStaticInitialization instance;

    static {
        instance = new SingletonStaticInitialization();
        // can perform som additional settings
    }

    private SingletonStaticInitialization() {
    }

    public static SingletonStaticInitialization getInstance() {
        return instance;
    }
}
