package com.ivan.polovyi.challenges;

/*
-- orElse() - if null returns default object
-- orElseGet() - if null returns some value from Supplier interface
-- orElseThrow () - if null returns exception
 */


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Optional;

public class OptionalElseExample {

    public static void main(String[] args) {


        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
    }

    private static String optionalOrElse() {
        // getting name of a student
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        // Will return Default if null passed
        return student.map(Student::getName).orElse("Default");
    }

    private static String optionalOrElseGet() {
        // getting name of a student
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        // Will return value from Supplier interface if null passed
        return student.map(Student::getName).orElseGet(() -> "Default");
    }

    private static String optionalOrElseThrow() {
        // getting name of a student
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        // Will return Exception if null passed
        return student.map(Student::getName).orElseThrow(() -> new RuntimeException("No data"));
    }
}
