package challemges.examples;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
  SECURITY VAULT
   -- How long it would take for hackers to guess security code?
      - Couple of hackers thread will try to guess the security code concurrently
      - One police thread will come to rescue by counting down 10 sec and if hackers haven't broken into
        vault, police will arrest them
      - Police will show us the progress of it arrival while counting down will show
   */
public class SecuredVault {
    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescenfingHackerThread(vault));
        threads.add(new PoliceThread());

        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static class Vault {

        private int password;

        private Vault(int password) {
            this.password = password;
        }

        public boolean isCorrect(int guess) {
            System.out.println("Password is: " + this.password + " and guess is " + guess);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.password == guess;
        }
    }


    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;

            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {

            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                if (vault.isCorrect(guess)) {

                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }


        }
    }

    private static class DescenfingHackerThread extends HackerThread {

        public DescenfingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {

            for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
                if (vault.isCorrect(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }


        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println("Game over for you hackers!");
            System.exit(0);
        }

    }
}
