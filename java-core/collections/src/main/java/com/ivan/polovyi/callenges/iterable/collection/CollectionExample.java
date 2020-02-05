package com.ivan.polovyi.callenges.iterable.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionExample {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();

        // add method
        populateCollection(collection);
        System.out.println("collection = " + collection);

        // add all
        Collection<Integer> collectionAddAll = new ArrayList<>();
        collectionAddAll.addAll(collection);
        System.out.println("collectionAddAll = " + collectionAddAll);

        // clear
        collectionAddAll.clear();
        System.out.println("collectionAddAll = " + collectionAddAll);

        //contains
        boolean contains = collection.contains(1);
        System.out.println("contains = " + contains);
        contains = collection.contains(100);
        System.out.println("contains = " + contains);

        //contains all
        boolean containsAllTrue = collection.containsAll(Arrays.asList(1, 2, 3));
        System.out.println("containsAllTrue = " + containsAllTrue);

        boolean containsAllFalse = collection.containsAll(Arrays.asList(1, 100, 3));
        System.out.println("containsAllFalse = " + containsAllFalse);

        // is empty
        boolean emptyFalse = collection.isEmpty();
        System.out.println("emptyFalse = " + emptyFalse);
        boolean emptyTrue = collectionAddAll.isEmpty();
        System.out.println("emptyTrue = " + emptyTrue);

        // remove at index
        boolean removeTrue = collection.remove(1);
        System.out.println("removeTrue = " + removeTrue);
        System.out.println("collection = " + collection);

        // remove an object (value)
        boolean removeObject = collection.remove(new Integer(2));
        System.out.println("removeObject = " + removeObject);
        System.out.println("collection = " + collection);

        // remove all
        boolean removeAll = collection.removeAll(Arrays.asList(4, 5));
        System.out.println("removeAll = " + removeAll);
        System.out.println("collection = " + collection);

        boolean removeAllNoContains = collection.removeAll(Arrays.asList(4, 5));
        System.out.println("removeAllNoContains = " + removeAllNoContains);
        System.out.println("collection = " + collection);

        // retain all
        populateCollection(collection);
        System.out.println("collection before = " + collection);
        boolean retainAll = collection.retainAll(Arrays.asList(1, 2));
        System.out.println("retainAll = " + retainAll);
        System.out.println("collection = " + collection);

        // to array of objects
        Object[] toArray = collection.toArray();
        for (Object o : toArray) {
            System.out.println("(Integer) o = " + (Integer) o);
        }

        // to array of type
        Integer[] toArrayTyped = collection.toArray(new Integer[collection.size()]);

        for (Integer i : toArrayTyped) {
            System.out.println("i = " + i);
        }

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
