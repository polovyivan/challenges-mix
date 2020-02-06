package com.ivan.polovyi.callenges.collections.iterable.collection.set;

import java.util.HashSet;
import java.util.Set;

/*
no duplicates
no order of insertion
fast to search
 */
public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(8);
        set.add(7);
        boolean addFirstTime = set.add(null);
        System.out.println("addFirstTime = " + addFirstTime);
        boolean addAlreadyExists = set.add(null);
        System.out.println("addAlreadyExists = " + addAlreadyExists);

        System.out.println("set = " + set);

        // does not have any additional methods

    }
}
