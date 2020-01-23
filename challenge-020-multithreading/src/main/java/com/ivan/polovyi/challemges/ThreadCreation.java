package com.ivan.polovyi.challemges;



/*
Thread constructors
- Thread()
- Thread(String name)
- Thread(Runnable r)
- Thread(Runnable r,String name)
 */
public class ThreadCreation {


    public static void main(String[] args) {

               // Implement the interface java.lang.Runnable
        // and pass an instance of the class implementing it to the Thread constructor.
        createTheadByPassingRunnabletoThreadConstructorPrioreJava8();

        createTheadByPassingRunnabletoThreadConstructorJava8();

        // Extending Thread class
        createThreadByExtendingThreadClass();


    }

    private static void createTheadByPassingRunnabletoThreadConstructorPrioreJava8() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // code that will run on a new thread
                System.out.println("We are in thread: " + Thread.currentThread().getName());
                System.out.println("Thread priority: " + Thread.currentThread().getPriority());
            }
        });

        // set name of a thread
        thread.setName("New worker thread");

        // ser priority of a thread
        thread.setPriority(10); // value from 1 to 10
        // or
        // thread.setPriority(Thread.MAX_PRIORITY); // using Thread class constants


        System.out.println("We are in thread " + Thread.currentThread().getName() + "before starting a new thread");
        thread.start();// this line instruct JVM to create a new thread and pass it to OS
        System.out.println("We are in thread " + Thread.currentThread().getName() + "after starting a new thread");

        // sleep instruct OS to don't schedule a thread during this period of time,
        // during that time this thread don't consume any CPU
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void createTheadByPassingRunnabletoThreadConstructorJava8() {
        Thread threadJava8 = new Thread(() -> {
            // code that will run on a new thread
            throw new RuntimeException("Exception ");
        });

        threadJava8.setName("Misbehaving thread");
        // unchecked exception if not handled will bring down entire thread
        // to avoid it
        threadJava8.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Critical error happened in a thread " + t.getName() +
                        "the error is " + e.getMessage());
            }
        });


        threadJava8.start();// this line instruct JVM to create a new thread and pass it to OS


    }

    private static void createThreadByExtendingThreadClass() {

        Thread thread = new NewThread();
        thread.start();
    }


    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("We are in thread : " + Thread.currentThread().getName() + " created by extending a Thread");
            // here we can use this instead of Thread
            System.out.println(this.getName());
        }
    }

}
