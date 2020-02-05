package com.ivan.polovyi.challenges.examples.challenges.data.interfexample.multipleinheritance;

public interface InterfaceIII extends InterfaceII{
    default void methodC() {
        System.out.println("Method C ");
    }
}
