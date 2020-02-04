package com.ivan.polovyi.challenges.streams.methods;


/*
map() method used for:
 - transform / convert one type to another
 - perform some operation on an object
 */

import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class MapMethod {

    public static void main(String[] args) {

        getListOfNameOfStudents();

    }

    private static void getListOfNameOfStudents() {

      /*
      print names of students
       */
        List<String> listOfStudentNames = StudentDataBase.getAllStudents().stream()
                //student as input -> name as output
                .map(s -> s.getName())
                // can be written in this way
                //.map(Student::getName)
                //map() can be chained
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        listOfStudentNames.forEach(s -> System.out.println(s));
        //.forEach(System.out::println);


    }
}
