package streams.methods.terminal.collect;


import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
mapping() Collector applies transformation function
first and than collects data in any type of collection
the same as map() + collect()...
 */
public class Mapping {
    public static void main(String[] args) {


        List<String> namesList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        Set<String> namesSet = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        Map<String, Double> studentsMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getName, Student::getGpa));


    }
}
