package com.ivan.polovyi.challenges;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample2 {
    public static void main(String[] args) {
        // handle null value in a collection using nullFirst and nullLAST
        List<Student> allStudents = StudentDataBase.getAllStudents();
        Comparator<Student> studentComparator = Comparator.nullsFirst(Comparator.comparing(Student::getName));
        allStudents.sort(studentComparator);
        allStudents.forEach(System.out::println);

    }
}
