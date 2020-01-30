package com.ivan.polovyi.challemges;


import java.math.BigInteger;

/* Thread termination - Why and when?
   -- Threads consume resources
      - memory and kernel resources
      - CPU cycles and cache memory
   -- If thread finished is work but app is still running, threads resources have to be cleaned
   -- If thread misbehaving, thread has to be terminated
   -- App won't stop until all threads are terminated
--------------------------------------------------------------------------------------------------
   -- Thread.interrupt()
      - threadB.interrupt() -> in threadA we calling this method on the object of threadB
    Use cases:
      - If thread executing method, that throws an InterruptedException
      - If threads code is handling the interrupt signal explicitly


 */
public class ThreadTerminator {


    public static void main(String[] args) {

        Thread tread = new BlockingTask();
        tread.start();
        // method call to interrupt thread
        tread.interrupt();
/*
------------------------------------------------------------------------------
 */
        // if we pass as an input large number, it will take long time to calculate a value
        Thread longCalculation =
                new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));

        longCalculation.start();
        // unlike a previous example longCalculation.interrupt() won't solve a problem because
        // it doesn't have any exception in it.
        // The solution is inside a method add if statement witch checks if this thread is
        // interrupted from outside
        longCalculation.interrupt();
    }

    private static class BlockingTask extends Thread {
        @Override
        public void run() {
            // code execution takes long time
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                // won't work if empty Catch block has to have a return statement or som line of code?
                System.out.println("Exiting blocking thread ");
            }
        }
    }

    private static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + " ^ " + power + "=" + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {

            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Permanently interrupted computation ");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
