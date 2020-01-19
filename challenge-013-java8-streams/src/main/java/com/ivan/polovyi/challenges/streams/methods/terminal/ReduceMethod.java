package com.ivan.polovyi.challenges.streams.methods.terminal;

/*
-- reduce() - used to reduce content of a stream to a single value
            - 1 parameter default or initial value
            - 2 parameter BinaryOperator<T>
 */

import com.ivan.polovyi.challenges.data.Student;
import com.ivan.polovyi.challenges.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMethod {
    public static void main(String[] args) {

        reduceMethod();

        // return student with highest GPA
        Optional<Student> studentWithHighestGPA = StudentDataBase.getAllStudents()
                .stream()
//                .reduce((s1, s2) -> {// because no default value, return is of type optional
//                    if (s1.getGpa() > s2.getGpa()) {
//                        return s1;
//                    } else {
//                        return s2;
//                    }
//                });
                // the same as above but shorter and readable
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }

    private static void reduceMethod() {
        // result of multiplication of all elements in a stream
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);

        Integer reduce = integers.stream()
                //1
                //3
                //5
                //7
                //1 iteration x = 1 (first parameter)
                //            y = first element from stream
                //1 iteration x = result from previous iteration(x*y)
                //            y = second element from stream
                // ....

                .reduce(1, (x, y) -> x * y);

        System.out.println(reduce);
    }
}
