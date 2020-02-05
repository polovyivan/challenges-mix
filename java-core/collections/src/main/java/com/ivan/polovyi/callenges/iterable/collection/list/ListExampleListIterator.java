package com.ivan.polovyi.callenges.iterable.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListExampleListIterator {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 10));

        // add at index
        list.add(1, 2);
        System.out.println("list = " + list);
        //  list.add(list.size() + 1, 11); throws java.lang.IndexOutOfBoundsException: Index: 11, Size: 10
        list.add(list.size(), 11);
        System.out.println("list = " + list);

        // add all at index
        // list.addAll(list.size() - 1, Arrays.asList(5, 4, 3));
        System.out.println("list = " + list);

        // get element at index
        Integer integer = list.get(1);
        System.out.println("integer = " + integer);

        // index of element
        int indexOfUniqueElement = list.indexOf(11);
        System.out.println("indexOf = " + indexOfUniqueElement);

        int indexOfMultipleOccurrenceValue = list.indexOf(5);
        System.out.println("indexOfMultipleOccurrenceValue = " + indexOfMultipleOccurrenceValue);

        // last index of
        int lastIndexOf = list.lastIndexOf(5);
        System.out.println("lastIndexOf = " + lastIndexOf);

        // set value at index

        Integer setValueAtIndex = list.set(0, 0);
        System.out.println("setValueAtIndex = " + setValueAtIndex);
        System.out.println("list = " + list);

        // list sort default method
        list.sort((e1, e2) -> e1 - e2);
        System.out.println("list = " + list);

        // sublist
        List<Integer> subList = list.subList(5, list.size());
        System.out.println("subList = " + subList);


        // list  iterator
        ListIterator<Integer> listIteratorEachValueAndIndex = list.listIterator();

        // forward iteration
        while (listIteratorEachValueAndIndex.hasNext()) {
            System.out.println("listIteratorEachValueAndIndex.next() = " + listIteratorEachValueAndIndex.next());
            System.out.println("listIteratorEachValueAndIndex.nextIndex() = " + listIteratorEachValueAndIndex.nextIndex());

        }

        System.out.println("list = " + list);

        ListIterator<Integer> listIteratorAdd = list.listIterator();
        while (listIteratorAdd.hasNext()) {
            // add value after every element
            listIteratorAdd.add(100);
            if (listIteratorAdd.next() == 100) {
                break;
            }
        }
        System.out.println("list after add = " + list);

        // set value after iteration
        listIteratorAdd.set(200);
        System.out.println("list after set = " + list);

        ListIterator<Integer> listIteratorRemove = list.listIterator();
        while (listIteratorRemove.hasNext()) {
            if (listIteratorRemove.next() == 100) {
                listIteratorRemove.remove();
            }
        }
        System.out.println("list after remove = " + list);


        // backward iteration
        ListIterator<Integer> listIteratorBackward = list.listIterator();

        while (listIteratorRemove.hasPrevious()) {
            System.out.println("listIteratorBackward value = " + listIteratorRemove.previous());
            System.out.println("listIteratorBackward  index= " + listIteratorRemove.previousIndex());
        }

        // Spliterator

    }
}
