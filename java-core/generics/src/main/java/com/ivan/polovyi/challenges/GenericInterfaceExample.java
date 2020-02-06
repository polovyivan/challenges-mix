package com.ivan.polovyi.challenges;

public class GenericInterfaceExample {

    // generic interface
    public interface GenericInterface<T> {
        void printString(T t);
    }

    private class GenericInterfaceImpl1 implements GenericInterface<Integer> {
        @Override
        public void printString(Integer integer) {

        }
    }

    private class GenericInterfaceImpl2 implements GenericInterface {
        @Override
        public void printString(Object o) {
        }
    }

    private class GenericInterfaceImpl3<T> implements GenericInterface<T> {
        @Override
        public void printString(T t) {
        }
    }
}
