package com.ivan.polovyi.challenges;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerCombination {

    public static void main(String[] args) {

        List<Student> allStudents = StudentDataBase.getAllStudents();
        //print names and activities if grade level >3 and gpa >=3.9
        Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
        Predicate<Student> p2 = s -> s.getGpa() >= 3.9;
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + "  : " + activities);
        Consumer<Student> tsConsumerFilter = s -> {
            if (p1.and(p2).test(s)) {
                biConsumer.accept(s.getName(), s.getActivities());
            }
        };
        allStudents.forEach(tsConsumerFilter);
    }
}
