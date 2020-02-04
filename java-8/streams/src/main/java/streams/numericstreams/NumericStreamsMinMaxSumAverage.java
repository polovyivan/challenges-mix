package streams.numericstreams;


import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
Aggregate methods
-- sum()
-- max()
-- min()
-- average()
 */
public class NumericStreamsMinMaxSumAverage {
    public static void main(String[] args) {

        int sum = IntStream.rangeClosed(1, 6)
                .sum();

        System.out.println("sum = " + sum);

        OptionalInt max = IntStream.rangeClosed(1, 6)
                .max();
        System.out.println("max = " + max);

        OptionalInt min = IntStream.rangeClosed(1, 6)
                .min();
        System.out.println("min = " + min);

        OptionalDouble average = IntStream.rangeClosed(1, 6).average();

        System.out.println("average = " + average);


    }
}
