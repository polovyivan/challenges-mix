package com.ivan.polovyi.challenges;

import java.util.ArrayList;
import java.util.List;

public class GenericsClassAndMethodsExample {

    public static void main(String[] args) {

        Generic<String> stringGeneric = new Generic<>();
        // stringGeneric.printString(11); does not compile with a number
        stringGeneric.printString("11");

        // in generic class it is not necessary to use it with diamond operator
        GenericConstructor<String> there = new GenericConstructor<>("there");
        GenericConstructor hi = new GenericConstructor("hi");

        // constructor is  typed whe used diamond operator on a right side
        new GenericConstructor<String>("5L");
        // does not compile
        //new GenericConstructor<String>(5L);
        new GenericConstructor(5L);

        // can use generics for reference and for instance independently
        GenericConstructor<String> genericConstructor = new GenericConstructor(5L);
        // doesn't compile
        // genericConstructor.printString(5L);

        List<Integer> numberList = new ArrayList<Integer>();
        // doesn't compile has to be equals from both sides
        // List<Number> numberList2 = new ArrayList<Integer>();


    }

    // generic class
    private static class Generic<T> {

        public void printString(T t) {
            System.out.println("t = " + t);
        }

        // generic method
        public <T> T genericMethod(T t) {
            return t;
        }
    }

    // generic class with constructor
    private static class GenericConstructor<T> {

        T t;

        public GenericConstructor(T t) {
            this.t = t;
        }


        public void printString(T t) {
            System.out.println("t = " + t);
        }

        // generic method
        public <T> T genericMethod(T t) {
            return t;
        }
    }


    //  class name has same name as a generics
    public class SameNameAsGenerics<S> {
        class S {

        }

        // doesn't compile because new S()
        // S s = new S();

    }

}
