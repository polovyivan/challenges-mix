package streams.methods.terminal.collect;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
-- partitioningBy() - kind of groupingBy()
                    - accepts Predicate as an input
                    - return Map where key is always boolean value

 */
public class PartitioningBy {

    public static void main(String[] args) {

        oneArgsVersion();

        twoArgumentsVersion();

    }

    private static void twoArgumentsVersion() {
        Predicate<Student> gpaPredicate = s -> s.getGpa() >= 3.8;
        Map<Boolean, Set<Student>> groupedByGPA = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));
    }

    private static void oneArgsVersion() {
        Predicate<Student> gpaPredicate = s -> s.getGpa() >= 3.8;
        // grouped by gpa
        Map<Boolean, List<Student>> groupedByGPA = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate));

        System.out.println("groupedByGPA = " + groupedByGPA);
    }
}
