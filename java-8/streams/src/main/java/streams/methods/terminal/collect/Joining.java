package streams.methods.terminal.collect;

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.stream.Collectors;

/*
joining() Collector performs String concatenation on the elements in a stream

 */
public class Joining {

    public static void main(String[] args) {
        joiningCollector();

        joinMethodWithDelimiter();

        joinMethodWithDelimiterPrefixAndSuffx();

    }

    private static void joinMethodWithDelimiterPrefixAndSuffx() {
        // concatenate all names of students in a stream
        String concatenatedWithDelimiterAndPrefixSuffixStudentNames = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "(", ")"));
        System.out.println("concatenatedWithDelimiterAndPrefixSuffixStudentNames = " +
                concatenatedWithDelimiterAndPrefixSuffixStudentNames);
    }

    private static void joiningCollector() {
        // concatenate all names of students in a stream
        String concatenatedStudentNames = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());

        System.out.println("concatenatedStudentNames = " + concatenatedStudentNames);
    }

    private static void joinMethodWithDelimiter() {
        // concatenate with delimiter all names of students in a stream
        String concatenatedWithDelimiterdStudentNames = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("_"));
        System.out.println("concatenatedWithDelimiterdStudentNames = " + concatenatedWithDelimiterdStudentNames);
    }
}
