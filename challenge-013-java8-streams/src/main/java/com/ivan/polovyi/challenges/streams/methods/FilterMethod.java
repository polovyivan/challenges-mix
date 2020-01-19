package com.ivan.polovyi.challenges.streams.methods;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

/*
-- filter() - filters the elements in a stream accepts as argument Predicate
              multiple filter can be chained
 */
public class FilterMethod {

    public static void main(String[] args) {

        // filter only female students
        List<Student> femaleStudents = StudentDataBase.getAllStudents()
                .stream()
                .filter(x -> x.getGender().equals("female"))
                .filter(x -> x.getGpa() >= 3.9)
                .collect(Collectors.toList());

        System.out.println(femaleStudents);
    }
}
