package com.ivan.polovyi.challenges;

public class GenericsClassAndMethodsExample {

    public static void main(String[] args) {

        Generic<String> stringGeneric = new Generic<>();
        // stringGeneric.printString(11); does not compile with a number
        stringGeneric.printString("11");
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


}
