package streams.methods;

/*
flatMap() used for:
    - transform / convert one type to another
    - perform some operation on an object
    - used when each element in a stream is a collection (Stream<List<String>>)
    Stream<String[]>		-> flatMap ->	Stream<String>
    Stream<Set<String>>	    -> flatMap ->	Stream<String>
    Stream<List<String>>	-> flatMap ->	Stream<String>
    Stream<List<Object>>	-> flatMap ->	Stream<Object>


 */

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapMethod {

    public static void main(String[] args) {

        flatMapMethod();

    }

    private static void flatMapMethod() {
        //using simple map()
        List<List<String>> studentActivities = StudentDataBase.getAllStudents().stream()//Stream <Student>
                .map(Student::getActivities)
                .peek(System.out::println)
                .collect(Collectors.toList());//Stream<List<String>>

        //to return List<String> stream has to be flattened using flatMap()
        List<String> studentActivitiesFlattened = StudentDataBase.getAllStudents().stream()//Stream <Student>
                .map(Student::getActivities)
                .flatMap(List::stream)
                // so far only one use case List::stream
                // or Collection::stream or(list -> list.stream())
                .peek(System.out::println)
                .collect(Collectors.toList());//Stream<List<String>>
    }
}
