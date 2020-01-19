package com.ivan.polovyi.challenges.streams.methods;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Optional;

/*
Used to find element in a stream and return it as an Optional
-- findFirst() - return first element in a stream;
-- findAny()   -  return first encountered element in a stream (when using parallel streams);
 */
public class FindFirstAnyMethods {

    public static void main(String[] args) {

        findAnyMethod();

// find any student that match filter condition
        Optional<Student> findFirst = StudentDataBase.getAllStudents().stream()
                //adam
                //jenny
                //emily
                .filter(s -> s.getGpa() >= 3.9)
                .findFirst();
    }

    private static void findAnyMethod() {
        // find any student that match filter condition
        Optional<Student> findAny = StudentDataBase.getAllStudents().stream()
                //adam
                //jenny
                //emily
                .filter(s -> s.getGpa() >= 3.9)
                .findAny();
        System.out.println("findAny = " + findAny);

    }
}
