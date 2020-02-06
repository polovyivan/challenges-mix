package com.ivan.polovyi.callenges.collections.iterable.collection.set.hash;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(4);
        hashSet.add(8);
        hashSet.add(7);
        boolean addFirstTime = hashSet.add(null);
        System.out.println("addFirstTime = " + addFirstTime);
        boolean addAlreadyExists = hashSet.add(null);
        System.out.println("addAlreadyExists = " + addAlreadyExists);

        System.out.println("hashSet = " + hashSet);

        // does not have any additional methods
    }
}
