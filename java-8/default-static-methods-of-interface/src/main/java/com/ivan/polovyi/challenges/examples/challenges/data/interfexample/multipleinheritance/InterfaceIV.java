package com.ivan.polovyi.challenges.examples.challenges.data.interfexample.multipleinheritance;

public interface InterfaceIV {

    default void methodA() {
        System.out.println("Method A " + InterfaceIII.class);
    }
}
