package com.ivan.polovy.challenges;

import com.ivan.polovy.challenges.data.Student;
import com.ivan.polovy.challenges.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {

        functionInterfaceExample();

        Consumer<Student> consumerLambdaExample = s -> System.out.println(s.getName());
        Consumer<Student> consumerMethodReferenceExample = System.out::println;
        StudentDataBase.getAllStudents().forEach(consumerLambdaExample);
        StudentDataBase.getAllStudents().forEach(consumerMethodReferenceExample);

    }

    private static void functionInterfaceExample() {
        Function<String, String> toUpperCaseLambda = s -> s.toUpperCase();
        Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

        System.out.println("toUpperCaseLambda = " + toUpperCaseLambda.apply("Java8"));
        System.out.println("toUpperCaseMethodReference = " + toUpperCaseMethodReference.apply("Java8"));
    }
}
