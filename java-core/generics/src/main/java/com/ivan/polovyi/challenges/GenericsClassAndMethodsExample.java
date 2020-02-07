package com.ivan.polovyi.challenges;

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

}
