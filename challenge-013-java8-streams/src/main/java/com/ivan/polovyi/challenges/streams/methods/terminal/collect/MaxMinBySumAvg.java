package com.ivan.polovyi.challenges.streams.methods.terminal.collect;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/*
-- maxBy() used in conjunction with comparator
   returns Optional MAX element based on the property passed to comparator
-- minBy() used in conjunction with comparator
   returns Optional MIN element based on the property passed to comparator
-- summingInt() Long, Double - return sum of collection elements
-- averagingInt() Long, Double - return average of collection.
 */
public class MaxMinBySumAvg {

    public static void main(String[] args) {

        // get student with list GPA
        Optional<Student> leastGPAStudent = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(s -> s.getGpa())));
        System.out.println("leastGPAStudent = " + leastGPAStudent);

        // get student with highest GPA
        Optional<Student> highestGPAStudent = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getName)));
        System.out.println("leastGPAStudent = " + highestGPAStudent);

        // get summation of all notebooks in a collection
        Integer notebooksTotal = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.summingInt((Student::getNoteBooks)));

        System.out.println("notebooksTotal = " + notebooksTotal);

        // get average of all notebooks in a collection
        Double notebooksAverage = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));

        System.out.println("notebooksAverage = " + notebooksAverage);


    }
}
