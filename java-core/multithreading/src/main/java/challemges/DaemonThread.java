package challemges;

/* Thread termination - Why and when?
   -- Threads consume resources
      - memory and kernel resources
      - CPU cycles and cache memory
   -- If thread finished is work but app is still running, threads resources have to be cleaned
   -- If thread misbehaving, thread has to be terminated
   -- App won't stop until all threads are terminated
--------------------------------------------------------------------------------------------------
   -- thread.setDaemon(true);
      - when main thread finished is terminates daemon thread
    Use cases:
      - Background tacks, that should nit block our application from terminating
        (Example - auto saver on text editor)

      - Code in a worker thread is not under our control, and we do not wont it to block our app
        from terminating
        (Example - call to an external library)

 */


import java.math.BigInteger;

public class DaemonThread {
    public static void main(String[] args) {
        Thread thread =
                new Thread(new LongComputationTask(new BigInteger("10000"), new BigInteger("100000")));

        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
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

                result = result.multiply(base);
            }
            return result;
        }
    }
}
