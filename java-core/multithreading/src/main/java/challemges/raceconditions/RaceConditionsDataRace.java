package challemges.raceconditions;


/*

   -- Race condition
      - when multiple threads accessing com.ivan.polovyi.challenges.data source
      - at least one thread is modifying resource
      - the timing of threads' scheduling may cause incorrect results
      - the core fo the problem is non atomic operations performed on shared resource
   -- Solution:
      - Identification of the critical section where the race condition is happening
      - protection of the critical section by synchronized block


   -- Data Race:
      - Compiler and CPU may execute the instructions out of order to optimize performance and utilization
      - They will do so while maintaining the logical correctness of the code
      - Out of order execution by compiler and CPU are important feature to speed up the code
      Data race
       - won't happen because of logical order
      x = 1;
      y = x+1;
      z = y+2;
       - will happen
       x++;
       y++;
       if(x>y) can give unexpected results
    -- Solution:
       - Synchronization of methods which modify shared variable
       - Declaration of variables with volatile word


       -- RULE OF THUMB:
          every shared variable should be either:
          - Guarded by synchronized block
           or
          - Declared volatile

 */
public class RaceConditionsDataRace {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkForDataRace();
            }

        });

        thread1.start();
        thread2.start();
    }

    public static class SharedClass {
        private volatile int x = 0; // without volatile (it guaranties an order)
        private volatile int y = 0; // it will give an unexpected result

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x - Data Race is detected");
            }
        }
    }

}
