package com.ivan.polovyi.challemges.atomicoperartions;


import java.util.Random;

/*

An atomic operation is an operation which is performed as a single unit of work without
the possibility of interference from other operations.
    ATOMIC OPERATIONS:
        -- all reference assignments - get and set references to an object
           Object a = new Object();
           Object b = new Object();
           a=b;
        -- all assignments to a primitive types (excluding long and double),
           that's mean reading from and writing thread safe
        -- double and long hve to be marked as volatile in order to be atomic
         */
// metrics example
public class AtomicOperations {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();

        BusinessLogic businessLogicYhread1 = new BusinessLogic(metrics);
        BusinessLogic businessLogicYhread2 = new BusinessLogic(metrics);

        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
        businessLogicYhread1.start();
        businessLogicYhread2.start();
        metricsPrinter.start();
    }

    public static class MetricsPrinter extends Thread {

        Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double currentAverage = metrics.getAverage();
                System.out.println("currentAverage = " + currentAverage);
            }
        }

    }


    public static class BusinessLogic extends Thread {
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();
                //business logic here

                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = System.currentTimeMillis();

                metrics.addSample(end - start);
            }
        }
    }

    public static class Metrics {

        // by adding volatile we guaranty atomicity of operations performed on average
        private volatile long count = 0;
        private volatile double average = 0.0;


        public synchronized void addSample(long sample) {
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;

        }

        public double getAverage() {
            return average;
        }
    }
}
