package com.ivan.polovyi.challenges.data.interfexample.multipleinheritance;

public interface InterfaceIII extends InterfaceII{
    default void methodC() {
        System.out.println("Method C ");
    }
}
