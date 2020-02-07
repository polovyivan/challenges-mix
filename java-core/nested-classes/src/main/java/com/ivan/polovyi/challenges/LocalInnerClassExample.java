package com.ivan.polovyi.challenges;

public class LocalInnerClassExample {

    private int length = 5;

    public static void main(String[] args) {
        LocalInnerClassExample localInnerClassExample = new LocalInnerClassExample();
        localInnerClassExample.calculate();
    }

    public void calculate() {
        // has to be final or effectively
        final int width = 20;

        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }
}
