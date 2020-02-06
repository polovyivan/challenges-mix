package com.ivan.polovyi.callenges.iterable.collection.set.sorted;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
    public static void main(String[] args) {

        SortedSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(4);
        sortedSet.add(8);
        sortedSet.add(7);
        try {
            sortedSet.add(null);
        } catch (NullPointerException e) {
            System.out.println("Does not allow null = " + e);
        }


        System.out.println("sortedSet = " + sortedSet);

        // SortedSet<E> subSet(E fromElement, E toElement);
        // Returns a view of the portion of this set whose elements range
        //     * from <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>,
        //     * exclusive.  (If <tt>fromElement</tt> and <tt>toElement</tt> are
        //     * equal, the returned set is empty.)
        SortedSet<Integer> subSet = sortedSet.subSet(2, 4);
        System.out.println("subSet = " + subSet);

        // SortedSet<E> headSet(E toElement);
        SortedSet<Integer> headSet = sortedSet.headSet(3);
        System.out.println("headSet = " + headSet);

        // SortedSet<E> tailSet(E fromElement);
        SortedSet<Integer> tailSet = sortedSet.tailSet(4);
        System.out.println("tailSet = " + tailSet);

        // E first();

        Integer first = sortedSet.first();
        System.out.println("first = " + first);

        // E last();
        Integer last = sortedSet.last();
        System.out.println("last = " + last);

        System.out.println("sortedSet = " + sortedSet);


    }
}
