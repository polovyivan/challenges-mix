package com.ivan.polovyi.challenges.examples.challenges.consumer;

/*
Consumer interface has one abstract method

-- void accept(T t); - accepts some input and perform some operation on that input
 */

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {

    public static void main(String[] args) {

        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        c1.accept("java8");

        List<Student> allStudents = StudentDataBase.getAllStudents();


        // print all students in a list
        Consumer<Student> studentConsumerPrintNames = student -> System.out.println(student);
        allStudents.forEach(studentConsumerPrintNames);

        //print name and list of activities of students
        Consumer<Student> studentsActivities = student -> System.out.println(student.getActivities());
        allStudents.forEach(studentConsumerPrintNames.andThen(studentsActivities)); // andThen() can be used multiple times

        //print name and list of activities of students using condition
        allStudents.forEach(student -> {
            if(student.getGradeLevel()>=3){
                studentConsumerPrintNames.andThen(studentsActivities).accept(student);
            }
        });


    }
}
