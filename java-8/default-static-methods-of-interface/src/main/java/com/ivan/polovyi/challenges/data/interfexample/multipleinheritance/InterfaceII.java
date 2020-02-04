package com.ivan.polovyi.challenges.data.interfexample.multipleinheritance;

public interface InterfaceII extends InterfaceI {
    default void methodB() {
        System.out.println("Method B ");
    }

    default void methodA() {
        System.out.println("Method A " + InterfaceIII.class);
    }
}
