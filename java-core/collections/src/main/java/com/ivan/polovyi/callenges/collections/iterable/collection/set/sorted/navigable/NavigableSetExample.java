package com.ivan.polovyi.callenges.collections.iterable.collection.set.sorted.navigable;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {

    public static void main(String[] args) {
        NavigableSet<Integer> navigableSet = new TreeSet<>();


        navigableSet.add(1);
        navigableSet.add(2);
        navigableSet.add(3);
        navigableSet.add(4);
        navigableSet.add(4);
        navigableSet.add(8);
        navigableSet.add(7);
        try {
            navigableSet.add(null);
        } catch (NullPointerException e) {
            System.out.println("Does not allow null = " + e);
        }

        System.out.println("navigableSet = " + navigableSet);

        // E lower(E e); returns first element that are lower then argument
        Integer lower = navigableSet.lower(3);
        System.out.println("lower = " + lower);

        // E floor(E e);
        Integer floorExactMatch = navigableSet.floor(7);
        System.out.println("floorExactMatch for 7 = " + floorExactMatch);

        Integer floorWhenNoMatch = navigableSet.floor(6);
        System.out.println("floorWhenNoMatch 6 = " + floorWhenNoMatch);

        //  E higher(E e);
        Integer higher = navigableSet.higher(3);
        System.out.println("higher = " + higher);

        //  E ceiling(E e);
        Integer ceiling = navigableSet.ceiling(3);
        System.out.println("ceiling = " + ceiling);

        // E pollFirst(); retrieve and remove
        Integer pollFirst = navigableSet.pollFirst();
        System.out.println("pollFirst = " + pollFirst);
        System.out.println("navigableSet = " + navigableSet);

        //  E pollLast();  retrieve and remove
        Integer pollLast = navigableSet.pollLast();
        System.out.println("pollLast = " + pollLast);
        System.out.println("navigableSet = " + navigableSet);

        // NavigableSet<E> descendingSet();
        NavigableSet<Integer> descendingSet = navigableSet.descendingSet();
        System.out.println("descendingSet = " + descendingSet);

    }
}
