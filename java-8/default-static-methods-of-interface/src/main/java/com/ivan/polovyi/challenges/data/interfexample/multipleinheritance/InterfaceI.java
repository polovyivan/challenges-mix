package com.ivan.polovyi.challenges.data.interfexample.multipleinheritance;

public interface InterfaceI {

    default void methodA() {
        System.out.println("Method A " + InterfaceIII.class);
    }
}
