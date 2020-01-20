package com.ivan.polovyi.challenges.function;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/*
 -- R apply(T t, U u); - accept 2 inputs and returns output.
 -- default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
 */
public class BiFunctionInterfaceExample {
    public static void main(String[] args) {
        BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction = (studentList,stPredicate)->{
           Map<String,Double> studentMap = new HashMap<>();

            studentList.forEach(s->{
                if(stPredicate.test(s)){
                    studentMap.put(s.getName(),s.getGpa());
                }
            });

           return studentMap;
        };

        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),
                s->s.getGradeLevel()>=3));
    }


}
