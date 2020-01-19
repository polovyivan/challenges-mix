package com.ivan.polovyi.challenges.streams.methods;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

/*
-- distinct() - returns a Stream with a unique elements
-- count() - returns long with total number of elements in a stream
 */
public class CountDistinctMethods {

    public static void main(String[] args) {

        distinctMethod();

        countMethod();


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
}
