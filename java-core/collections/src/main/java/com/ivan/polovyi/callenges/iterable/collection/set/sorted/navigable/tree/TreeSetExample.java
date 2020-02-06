package com.ivan.polovyi.callenges.iterable.collection.set.sorted.navigable.tree;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(4);
        treeSet.add(8);
        treeSet.add(7);
        try {
            treeSet.add(null);
        } catch (NullPointerException e) {
            System.out.println("Does not allow null = " + e);
        }

        System.out.println("treeSet = " + treeSet);

        TreeSet<Integer> treeSetFromCollection = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // does not have any new methods

    }
}
