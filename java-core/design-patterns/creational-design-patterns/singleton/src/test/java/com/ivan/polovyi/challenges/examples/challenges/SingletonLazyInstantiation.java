package com.ivan.polovyi.challenges.examples.challenges;

public class SingletonLazyInstantiation {

    private static volatile SingletonLazyInstantiation instance;

    private SingletonLazyInstantiation() {
    }

    // not thread save
//    public static SingletonLazyInstantiation getInstance() {
//
//        if (instance == null) {
//            instance = new SingletonLazyInstantiation();
//        }
//
//        return instance;
//    }

    // thread save
    public static SingletonLazyInstantiation getInstance() {

        // double checking locking
        if (instance == null) {
            synchronized (SingletonStaticInitialization.class) {
                if (instance == null) {
                    instance = new SingletonLazyInstantiation();
                }
            }
        }

        return instance;
    }
}
