package com.ivan.polovyi.challenges.predicate;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.function.BiPredicate;

/*
Predicate interface has one abstract method

-- boolean test(T t, U u); - accepts 2 inputs and return boolean
-- default Predicate<T> and (Predicate<? super T> other);
-- default Predicate<T> or (Predicate<? super T> other);
-- default Predicate <T> negate();
-- static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
 */
public class BiPredicateInterfaceExample {

    public static void main(String[] args) {
        List<Student> allStudents = StudentDataBase.getAllStudents();

        BiPredicate<Integer, Double> pr = (grateLevel, gpa) -> grateLevel >= 2 && gpa >= 3.8;

        allStudents.forEach(s -> {
            if (pr.test(s.getGradeLevel(), s.getGpa())) {
                System.out.println(s);
            }
        });
    }
}
