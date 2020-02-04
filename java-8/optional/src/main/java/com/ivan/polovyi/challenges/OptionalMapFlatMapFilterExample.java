package com.ivan.polovyi.challenges;


import com.ivan.polovyi.challenges.data.Bike;
import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Optional;

/*
 -- map() -
 -- flatMap() - get optional object inside another optional object
 -- filter() -

 */
public class OptionalMapFlatMapFilterExample {

    public static void main(String[] args) {
        optionalFilter();

        optionalMap();

        optionalFlatMap();

    }


    private static void optionalFilter() {
        // filter
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        student.filter(s -> s.getGpa() >= 3.5)
                .ifPresent(System.out::println);
    }

    private static void optionalMap() {
        //map
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        if (student.isPresent()) {
            student.filter(s -> s.getGpa() >= 3.5)
                    .map(Student::getName);

            System.out.println(student.get());
        }
    }

    private static void optionalFlatMap() {
        //flatMap
        // printing bike name
        Optional<String> name = StudentDataBase.getOptionalStudent()
                .filter(s -> s.getGpa() >= 3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        if (name.isPresent()) {
            System.out.println("bikeName = " + name.get());
        }

    }
}