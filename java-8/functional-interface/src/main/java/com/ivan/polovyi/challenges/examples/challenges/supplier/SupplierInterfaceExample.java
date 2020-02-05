package com.ivan.polovyi.challenges.examples.challenges.supplier;

import com.ivan.polovyi.challenges.examples.challenges.data.Student;

import java.util.Arrays;
import java.util.function.Supplier;

/*
 -- T get(); - opposite to Consumer
 */

public class SupplierInterfaceExample {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = ()-> new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"),11);
        System.out.println("studentSupplier.get() = " + studentSupplier.get());
    }
}
