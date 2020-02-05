package com.ivan.polovyi.challenges.examples.challenges.consumer;


import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

/*
BiConsumer interface has one abstract method

-- void accept(T t,U u); - accepts 2 inputs and perform some operation on that input
 */
public class BiConsumerInterfaceExample {

    public static void main(String[] args) {

        BiConsumer<String, String> biC = (a, b) -> System.out.println("a= " + a + "b= " + b);
        biC.accept("java7", "java7");

        BiConsumer<Integer, Integer> multiplication = (a, b) -> System.out.println("a*b= " + (a * b));
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("a/b= " + (a / b));
        multiplication.andThen(division).accept(10, 5);

        //print student name and activities
        List<Student> allStudents = StudentDataBase.getAllStudents();
        BiConsumer<String, List<String>> nameActivities = (name, activities) -> System.out.println(name + " " + activities);
        allStudents.forEach(s -> nameActivities.accept(s.getName(), s.getActivities()));

    }
}
