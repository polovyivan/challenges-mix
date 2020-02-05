package com.ivan.polovyi.callenges.iterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IterableAndIterator {

    public static void main(String[] args) {
        ArrayList<Integer> iterable = new ArrayList<>();
        populateCollection(iterable);

        // iterate over
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator value = " + iterator.next());
        }

        Iterator<Integer> iteratorRemove = iterable.iterator();
        while (iteratorRemove.hasNext()) {
            if (iteratorRemove.next() < 3) {
                iteratorRemove.remove();
            }
        }
        System.out.println("iterable = " + iterable);

        // for each

        // spliterator ...

    }

    private static void populateCollection(Collection<Integer> collection) {
        collection.clear();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
    }
}
