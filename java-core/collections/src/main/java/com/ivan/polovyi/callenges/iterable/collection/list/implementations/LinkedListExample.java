package com.ivan.polovyi.callenges.iterable.collection.list.implementations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {

    public static void main(String[] args) {

        // Creation
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        LinkedList<Integer> linkedListFromCollection = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, null, null));
        System.out.println("linkedListFromCollection = " + linkedListFromCollection);

        System.out.println("linkedList = " + linkedList);
        // add first
        linkedList.addFirst(0);
        System.out.println("linkedList added first = " + linkedList);

        //add last
        linkedList.addLast(6);
        System.out.println("linkedList added last = " + linkedList);

        // get first
        Integer first = linkedList.getFirst();
        System.out.println("first = " + first);
        System.out.println("linkedList = " + linkedList);

        // get last
        Integer last = linkedList.getLast();
        System.out.println("last = " + last);
        System.out.println("linkedList = " + linkedList);

        // boolean offerFirst(E e)

        // boolean offerLast(E e)

        // boolean peekFirst(E e)

        // boolean peekLast(E e)

        // boolean pollFirst(E e)

        // boolean pollLast(E e)

        // E push()

        // E pop()




        //E removeFirst()


        // E removeLast()


        // boolean removeFirstOccurrence(Object o)


        // descending iterator backward iteration
        Iterator<Integer> descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("descendingIterator = " + descendingIterator.next());
        }

        //
        ListIterator<Integer> integerListIterator = linkedList.listIterator();

        ListIterator<Integer> listIteratorFromIndex = linkedList.listIterator(3);

    }

}
