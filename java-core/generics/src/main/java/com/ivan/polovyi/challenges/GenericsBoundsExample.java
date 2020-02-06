package com.ivan.polovyi.challenges;

import java.util.ArrayList;
import java.util.List;

public class GenericsBoundsExample {

    // Unbounded wildcard
    List<?> unbounded1 = new ArrayList<String>();
    List<?> unbounded2 = new ArrayList<Integer>();
    // ... accepts any

    // Upper bound
    List<? extends Number> upperBound1 = new ArrayList<Number>();
    List<? extends Number> upperBound2 = new ArrayList<Integer>();
    // doesn't compile because Number is a bound
    /*
    Object.class
         |
   -------bound---------
    Number.class
         |
    Integer.class
     */

    // List<? extends Number> upperBound3 = new ArrayList<Object>();

    // Lower bound
    List<? super Number> lowerBound1 = new ArrayList<Number>();
    List<? super Number> lowerBound2 = new ArrayList<Object>();

    // doesn't compile because Number is a bound
    /*
    Object.class
         |
    Number.class
   -------bound---------
         |
    Integer.class
     */
    //List<? super Number> lowerBound3 = new ArrayList<Integer>();
}
