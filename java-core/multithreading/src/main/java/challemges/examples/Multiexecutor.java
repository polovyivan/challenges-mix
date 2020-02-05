package challemges.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/*
In this exercise we are going to implement a  MultiExecutor .

The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.

When the client runs the . executeAll(),  the MultiExecutor,  will execute all the given tasks.

To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks concurrently, by passing each task to a different thread.
 */


public class Multiexecutor {

    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();

        IntStream.rangeClosed(0, 10)
                .forEach(n -> tasks.add(() -> System.out.println(n)));


        Multiexecutor me = new Multiexecutor(tasks);
        me.executeAll();
    }

    private List<Runnable> tasks = new ArrayList<>();

    public Multiexecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        tasks.forEach(task -> new Thread(task).start());
    }
}
