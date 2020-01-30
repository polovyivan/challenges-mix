package com.ivan.polovyi.challemges.locking;

/*

    LOCKING STRATEGIES
       -- Fine-Grained - multiple locks (separate lock for every resource using synchronized block)
          can cause a
           DEADLOCK (circular dependency) if all conditions are met:
           - mutual exclusion - only one thread can have exclusive access to a resource
           - hold and wait - at least one thread is holding a resource and is waiting for another resource
           - none-preemptive allocation - resource is released only after thread is done using it
           - circular wait - a chain of at least two threads each one is holding one resource
             and waiting for another resource

            Solution for Deadlock:
            - Avoiding circular wait - enforce a strict order in lock acquisition

       -- Coarse-Grained - one general lock ( synchronized used on methods)
 */


import java.util.Random;

public class DeadLock {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread threadA = new Thread(new TrainA(intersection));
        Thread threadB = new Thread(new TrainB(intersection));
        threadA.start();
        threadB.start();
    }


    public static class TrainA implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }


        @Override
        public void run() {
            while (true) {
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                intersection.takeRoadA();
            }
        }
    }

    public static class TrainB implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }


        @Override
        public void run() {
            while (true) {
                long sleepTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                intersection.takeRoadB();
            }
        }
    }


    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A synchronized by " + Thread.currentThread().getName());

                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void takeRoadB() {

            // DEADLOCK
//            synchronized (roadB) {
//                System.out.println("Road B synchronized by " + Thread.currentThread().getName());
//
//                synchronized (roadA) {
//                    System.out.println("Train is passing through road B");
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

        // Resolving deadlock by adjuting order of resource locking
            synchronized (roadA) {
                System.out.println("Road A synchronized by " + Thread.currentThread().getName());

                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
