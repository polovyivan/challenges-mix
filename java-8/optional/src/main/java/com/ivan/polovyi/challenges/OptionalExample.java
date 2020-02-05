package com.ivan.polovyi.challenges;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Optional;

/*
-- represents non null values
-- avoids null pointer exception and unnecessary null checks
 */
public class OptionalExample {
    public static void main(String[] args) {

        // Traditional way with many null checks

        String studentName = getStudentName();

        System.out.println("studentName = " + studentName);

        if (studentName != null) {
            System.out.println("nameLength = " + studentName.length());
        } else {
            System.out.println("Student not found");
        }

        // With optional
        Optional<String> studentNameOptional = getStudentNameOptional();

        if(studentNameOptional.isPresent()){
            System.out.println("studentNameOptionalLength = " + studentNameOptional.get().length());
        }

    }

    public static Optional<String> getStudentNameOptional() {
       // Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Line below returns null
        Optional<Student> student = Optional.ofNullable(null );
        if (student.isPresent()) {
            return student.map(Student::getName); // Optional<Student> -> Optional<String>
        }
        return Optional.empty(); //Represents an optional object with no value
    }


    public static String getStudentName() {
        Student student = StudentDataBase.studentSupplier.get();
        // Line bellow gives nul pointer exception
        // Student student = null;

        if (student != null) {
            return student.getName();
        }

        return null;
    }
}
