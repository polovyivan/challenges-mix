package com.ivan.polovyi.callenges.collections.iterable.collection.list.implementations;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample {

    public static void main(String[] args) {

        // create ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayList<Integer> arrayListInitialCapacity = new ArrayList<>(10);

        // to ensure capacity
        arrayListInitialCapacity.ensureCapacity(10);

        arrayListInitialCapacity.add(1);
        arrayListInitialCapacity.add(2);
        arrayListInitialCapacity.add(3);
        arrayListInitialCapacity.add(4);
        arrayListInitialCapacity.add(5);


        ArrayList<Integer> arrayListCreateFromCollection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null));

        // remove range works only from subclass because it is protected
        // arrayListInitialCapacity.removeRange(1,3);

        /* trim to size
          |1|2|3|4|5| | | | | |
          |1|2|3|4|5|
        */
        System.out.println("arrayListInitialCapacity before trim= " + arrayListInitialCapacity.size());
        arrayListInitialCapacity.trimToSize();
        System.out.println("arrayListInitialCapacity after trim  = " + arrayListInitialCapacity.size());
    }
}
