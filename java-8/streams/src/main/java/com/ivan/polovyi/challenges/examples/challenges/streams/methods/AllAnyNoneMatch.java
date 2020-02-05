package com.ivan.polovyi.challenges.examples.challenges.streams.methods;


import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

/*
All methods accept Predicate as a parameter, and return boolean
 -- anyMatch() - returns TRUE if any element in a stream match predicate, otherwise false
 -- allMatch() - returns TRUE if all elements in a stream match predicate, otherwise false
 -- noneMatch() - opposite of allMatch(), returns TRUE if none elements in a stream match predicate, otherwise false
 */
public class AllAnyNoneMatch {

    public static void main(String[] args) {

        boolean allMatch = StudentDataBase.getAllStudents().stream()
                .allMatch(s -> s.getGpa() >= 3.9);
        System.out.println("allMatch = " + allMatch);

        boolean anyMatch = StudentDataBase.getAllStudents().stream()
                .anyMatch(s -> s.getGpa() >= 4.2);
        System.out.println("anyMatch = " + anyMatch);

        boolean noneMatch = StudentDataBase.getAllStudents().stream()
                .noneMatch(s -> s.getGpa() >= 4.2);
        System.out.println("anyMatch = " + anyMatch);


    }
}
