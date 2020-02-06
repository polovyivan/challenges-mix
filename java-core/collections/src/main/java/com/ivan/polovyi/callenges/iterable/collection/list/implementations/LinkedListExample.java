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

        // boolean offer(E e) Adds the specified element as the tail (last element) of this list.
        linkedList.add(2);
        boolean offer = linkedList.offer(2);
        System.out.println("offer = " + offer);
        System.out.println("linkedList = " + linkedList);

        // boolean offerFirst(E e) Inserts the specified element at the front of this list
        boolean offerFirst = linkedList.offerFirst(-1);
        System.out.println("offerFirst = " + offerFirst);
        System.out.println("linkedList = " + linkedList);


        // boolean offerLast(E e) Inserts the specified element at the end of this list
        boolean offerLast = linkedList.offerLast(10);
        System.out.println("offerLast = " + offerLast);
        System.out.println("linkedList = " + linkedList);


        // boolean peek(E e) Retrieves, but does not remove, the head (first element) of this list.
        Integer peek = linkedList.peek();
        System.out.println("peek = " + peek);
        System.out.println("linkedList = " + linkedList);

        // boolean peekFirst(E e) Retrieves, but does not remove, the first element of this list,
        //or returns {@code null} if this list is empty.
        Integer peekFirst = linkedList.peekFirst();
        System.out.println("peekFirst = " + peekFirst);
        System.out.println("linkedList = " + linkedList);

        // boolean peekLast(E e) Retrieves, but does not remove, the last element of this list,
        // or returns {@code null} if this list is empty.
        Integer peekLast = linkedList.peekLast();
        System.out.println("peekLast = " + peekLast);
        System.out.println("linkedList = " + linkedList);

        // boolean poll(E e) Retrieves and removes the head (first element) of this list.
        Integer poll = linkedList.poll();
        System.out.println("poll = " + poll);
        System.out.println("linkedList = " + linkedList);

        // boolean pollFirst(E e) Retrieves and removes the first element of this list,
        // or returns {@code null} if this list is empty.
        Integer pollFirst = linkedList.pollFirst();
        System.out.println("pollFirst = " + pollFirst);
        System.out.println("linkedList = " + linkedList);

        // boolean pollLast(E e) Retrieves and removes the last element of this list,
        // or returns {@code null} if this list is empty.
        Integer pollLast = linkedList.pollLast();
        System.out.println("integer = " + pollLast);
        System.out.println("linkedList = " + linkedList);

        // E push() Pushes an element onto the stack represented by this list.  In other
        //words, inserts the element at the front of this list
        linkedList.push(100);
        System.out.println("push 100");
        System.out.println("linkedList = " + linkedList);

        // E pop() Pops an element from the stack represented by this list.  In other
        // words, removes and returns the first element of this list.
        Integer pop = linkedList.pop();
        System.out.println("pop = " + pop);
        System.out.println("linkedList = " + linkedList);

        //E removeFirst() Removes and returns the first element from this list.
        Integer removeFirst = linkedList.removeFirst();
        System.out.println("removeFirst = " + removeFirst);
        System.out.println("linkedList = " + linkedList);

        // E removeLast() Removes and returns the last element from this list.
        Integer removeLast = linkedList.removeLast();
        System.out.println("removeLast = " + removeLast);
        System.out.println("linkedList = " + linkedList);


        // boolean removeFirstOccurrence(Object o) Removes the first occurrence of the specified element in this
        // list (when traversing the list from head to tail).  If the list
        //  does not contain the element, it is unchanged.
        boolean removeFirstOccurrence = linkedList.removeFirstOccurrence(2);
        System.out.println("removeFirstOccurrence = " + removeFirstOccurrence);
        System.out.println("linkedList = " + linkedList);

        // boolean removeLastOccurrence(Object o) Removes the last occurrence of the specified element in this
        // list (when traversing the list from head to tail).  If the list
        // does not contain the element, it is unchanged.
        boolean removeLastOccurrence = linkedList.removeLastOccurrence(2);
        System.out.println("removeLastOccurrence = " + removeLastOccurrence);
        System.out.println("linkedList = " + linkedList);


        // descending iterator backward iteration
        Iterator<Integer> descendingIterator = linkedList.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("descendingIterator = " + descendingIterator.next());
        }

        // Returns a list-iterator of the elements in this list (in proper
        //  sequence), starting at the specified position in the list.
        ListIterator<Integer> listIteratorFromIndex = linkedList.listIterator(1);
        while (listIteratorFromIndex.hasNext()) {
            System.out.println("listIteratorFromIndex.next() = " + listIteratorFromIndex.next());
        }


    }

}
