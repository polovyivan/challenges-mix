package com.ivan.polovyi.challenges.predicate;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

/*
Predicate interface has one abstract method

-- boolean test(T t); - accepts some input and return boolean
-- default Predicate<T> and (Predicate<? super T> other);
-- default Predicate<T> or (Predicate<? super T> other);
-- default Predicate <T> negate();
-- static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
 */
public class PredicateInterfaceExample {

    public static void main(String[] args) {

        Predicate<Integer> checkIfEven = i -> i % 2 == 0;
        System.out.println("checkIfEven = " + checkIfEven.test(4));


        Predicate<Integer> checkIfDivisibleBy5 = i -> i % 5 == 0;
        System.out.println(checkIfEven.and(checkIfDivisibleBy5).test(10));
        System.out.println(checkIfEven.or(checkIfDivisibleBy5).test(15));
        System.out.println(checkIfEven.negate().test(15));

        //print students with grade level more than 3 and gpa >=3.6
        Predicate<Student> gradeLevel = s -> s.getGradeLevel() > 3;
        Predicate<Student> gpaLevel = s -> s.getGpa() > 3.6;

        List<Student> allStudents = StudentDataBase.getAllStudents();
        allStudents.forEach(s -> {
            if (gradeLevel.and(gpaLevel).test(s)) {// or can be applied
                System.out.println(s);
            }
        });

    }
}
