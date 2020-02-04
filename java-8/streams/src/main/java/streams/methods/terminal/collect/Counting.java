package streams.methods.terminal.collect;


import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.stream.Collectors;

/*
counting() - returns total number of elements as a result.

 */
public class Counting {

    public static void main(String[] args) {

       // count total number of students with gpa more than 3.9
        Long totalCountOfElements = StudentDataBase.getAllStudents().stream()
                .filter(s->s.getGpa()>3.9)
                .collect(Collectors.counting());

        System.out.println("totalCountOfElements = " + totalCountOfElements);

    }
}
