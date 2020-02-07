package com.ivan.polovyi.challenges;

public class StaticNestedClassExample {

    public static void main(String[] args) {

       Nested nested = new Nested();
        int price = nested.price;
        System.out.println("price = " + price);
    }

    static class Nested{
        private int price = 6;

    }
}
