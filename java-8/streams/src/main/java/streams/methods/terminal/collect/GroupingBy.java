package streams.methods.terminal.collect;

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

/*
-- groupBy() - used to group elements by property to Map
 */
public class GroupingBy {

    public static void main(String[] args) {
        oneArgumentVersion();

        twoArgumentVersion();

        threeArgumentsVersion();

        groupingByAndMaxByMnBy();

    }


    private static void oneArgumentVersion() {
        // group students by gender
        Map<String, List<Student>> studentsByGender = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));

        System.out.println("studentsByGender = " + studentsByGender);

        // customized grouping by based on GPA
        Map<String, List<Student>> groupedByGPA = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println("groupedByGPA = " + groupedByGPA);
    }

    private static void twoArgumentVersion() {
        // 2 level grouping by grade level and GPA
        Map<Integer, Map<String, List<Student>>> twoLevelMapping = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println("twoLevelMapping = " + twoLevelMapping);

        // 2 level grouping by grade level and GPA
        Map<Integer, Integer> groupedByGradeLevelAndNotebooks = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.summingInt(Student::getNoteBooks)));
        System.out.println("groupedByGradeLevelAndNotebooks = " + groupedByGradeLevelAndNotebooks);
    }


    private static void threeArgumentsVersion() {
        // Students by name
        LinkedHashMap<String, Set<Student>> studentsByName = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));

        System.out.println("studentsByName = " + studentsByName);
    }

    private static void groupingByAndMaxByMnBy() {
        // top GPA student in each grade
        Map<Integer, Optional<Student>> topStudentInEachGrade = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println("topStudentInEachGrade = " + topStudentInEachGrade);


        // without optional  using Collectors.collectingAndThen
        Map<Integer, Student> topStudentInEachGradeWithNoOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
        System.out.println("topStudentInEachGradeWithNoOptional = " + topStudentInEachGradeWithNoOptional);

        // least GPA student in each grade
        Map<Integer, Optional<Student>> leastStudentInEachGrade = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.minBy(Comparator.comparing(Student::getGpa))));
        System.out.println("leastStudentInEachGrade = " + leastStudentInEachGrade);


    }
}
