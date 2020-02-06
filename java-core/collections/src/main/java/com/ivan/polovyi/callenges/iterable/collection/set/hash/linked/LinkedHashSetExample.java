package com.ivan.polovyi.callenges.iterable.collection.set.hash.linked;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(4);
        linkedHashSet.add(8);
        linkedHashSet.add(7);

        boolean addFirstTime = linkedHashSet.add(null);
        System.out.println("addFirstTime = " + addFirstTime);
        boolean addAlreadyExists = linkedHashSet.add(null);
        System.out.println("addAlreadyExists = " + addAlreadyExists);

        System.out.println("linkedHashSet = " + linkedHashSet);

        // does not have any additional methods
    }
}
