package com.ivan.polovyi.challenges.streams.methods;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
-- distinct() - returns a Stream with a unique elements
-- count() - returns long with total number of elements in a stream
 */
public class CountDistinctSkipLimitMethods {

    public static void main(String[] args) {

        distinctMethod();

        countMethod();

        limitMethod();

        skipMethod();

    }

    private static void distinctMethod() {
        //removes duplicates
        List<String> studentActivitiesFlattened = StudentDataBase.getAllStudents().stream()//Stream <Student>
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() // used to flattened stream (Stream<List<Object>>	-> Stream<Object>)
                .peek(System.out::println)
                .collect(Collectors.toList());//Stream<List<String>>
    }

    private static void countMethod() {
        //total number of elements in a stream
        long studentActivitiesCount = StudentDataBase.getAllStudents().stream()//Stream <Student>
                .map(Student::getActivities)
                .flatMap(List::stream)// used to flattened stream (Stream<List<Object>>	-> Stream<Object>)
                .count();

        System.out.println(studentActivitiesCount);
    }

    private static void limitMethod() {
        // limit() - limits n numbers of elements
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> limited = integerList.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("limited = " + limited);
    }

    private static void skipMethod() {
        // skip() - skips  n numbers of element
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> skiped = integerList.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("skiped = " + skiped);
    }
}
