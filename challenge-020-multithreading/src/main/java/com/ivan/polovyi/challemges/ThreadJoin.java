package com.ivan.polovyi.challemges;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    THREAD COORDINATION
    -- Why we need it?
       - different threads run independently
       - order of execution is out of control
    -- can be achieved using:
       public final void join() - method which allows one thread to wait until another thread completes its execution.;
       public final void join(ong millis);
       public final void join(long millis,int nanos);
When we invoke the join() method on a thread, the calling thread goes into a waiting state.
It remains in a waiting state until the referenced thread terminates.


  Main thread-->----->--->-->--block##########continue--->---->
                 \                 |               |
sub thread start()\                | join()        |
                   \               |               |
                    ---sub thread----->--->--->--finish
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
        // we want to calculate factorial values 0!...5566!
        // it is very CPU consuming operation

        // create threads
        List<FactorialThread> threads = new ArrayList<>();
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }
        // start threads
        threads.forEach(t->t.setDaemon(true));
        threads.forEach(FactorialThread::start);

        // without this line of code we will have race condition between thread.start
        // and factorialThread.isFinished()
        // this way forces main thread to wait until all factorial threads are finished
        for (FactorialThread thread : threads) {
            // this method will return only when factorial method is terminated
            // by the time main thread finished this loop, all factorial threads will be finished guarantied
            thread.join(2000);
            // should always decide how long we gonna wait for for each thread and pass that value into join()
            // because if we pass huge number, main thread will be waiting for it termination
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.result);
            } else {
                System.out.println("Calculation for number " + inputNumbers.get(i) + " is still in progress");
            }
        }


    }

    private static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        private BigInteger factorial(long inputNumber) {

            BigInteger tempResult = BigInteger.ONE;

            for (long i = inputNumber; i >0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
