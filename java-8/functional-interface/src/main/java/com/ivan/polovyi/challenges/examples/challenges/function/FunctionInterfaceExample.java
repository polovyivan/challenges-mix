package com.ivan.polovyi.challenges.examples.challenges.function;

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/*
 -- R apply(T t); - accept input and returns output.
 -- default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
 -- default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
 */
public class FunctionInterfaceExample {
    public static void main(String[] args) {

        Function<String, String> stringToUpperCase = name -> name.toUpperCase();
        Function<String, String> concateString = name -> name.concat(" default ");
        System.out.println("Result " + stringToUpperCase.apply("Java8"));
        System.out.println("Result and then " + stringToUpperCase.andThen(concateString).apply("Java8"));
        System.out.println("Result and compose " + stringToUpperCase.compose(concateString).apply("Java8"));

        // create map of students and their respective gpa
        Function<List<Student>, Map<String, Double>> getMap = students -> {
            Map<String, Double> studentsGradeMap = new HashMap<>();
            students.forEach(s -> studentsGradeMap.put(s.getName(), s.getGpa()));
            return studentsGradeMap;
        };
        System.out.println(getMap.apply(StudentDataBase.getAllStudents()));
    }
}
