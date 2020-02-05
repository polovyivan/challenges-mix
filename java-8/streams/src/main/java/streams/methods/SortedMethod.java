package streams.methods;

import com.ivan.polovyi.challenges.examples.challenges.data.Student;
import com.ivan.polovyi.challenges.examples.challenges.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
-- sorted() - sort elements in a stream in natural order
-- sorted(Comparator c) - sort elements in a stream in custom order
 */
public class SortedMethod {

    public static void main(String[] args) {

        sortedMethodNaturalSort();

        sortMethodCustomOrder();

    }


    private static void sortedMethodNaturalSort() {
        //removes duplicates and sort in natural sort
        List<String> studentActivitiesFlattened = StudentDataBase.getAllStudents().stream()//Stream <Student>
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct() // used to flattened stream (Stream<List<Object>>	-> Stream<Object>)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());//Stream<List<String>>
    }

    private static void sortMethodCustomOrder() {
        // sort students in a stream by their names
        List<Student> orderedByName = StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName).reversed())//comparing accepts Function
                //in addition reversed() can be called to reverse an order

                //.sorted(Comparator.comparing(s->s.getName()))// or like this but reversed() cant be callad
                .collect(Collectors.toList());

        System.out.println(orderedByName);

    }
}
