package streams.methods;

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

public class MapFilterReducePattern {

    public static void main(String[] args) {
        MapFilterReduce();
    }

    private static void MapFilterReduce() {
        // total amount of notebooks of  students that have gpa more than 3.9 and have more than 12 notebooks
        Integer totalNumberOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGpa()>3.5)
                .map(Student::getNoteBooks)
                .filter(n->n>12)
                // .reduce(0,Integer::sum); - similar approach using Integer class
                .reduce(0, (x, y) -> x + y);
        System.out.println(totalNumberOfNotebooks);
    }
}
