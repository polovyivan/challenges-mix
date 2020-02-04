package com.ivan.polovy.challenges;


import com.ivan.polovy.challenges.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

/*
 -- method references can be used only in context of Supplier functional interface
 -- class has to have minimum one no args constructor
  */
public class ConstructorReference {

    public static void main(String[] args) {

        Supplier<Student> studentSupplier = Student::new;

        System.out.println("studentSupplier = " + studentSupplier.get());

        Function<String, Student> createStudent = Student::new;

        System.out.println("createStudent.apply(Ivan) = " + createStudent.apply("Ivan"));
    }
}
