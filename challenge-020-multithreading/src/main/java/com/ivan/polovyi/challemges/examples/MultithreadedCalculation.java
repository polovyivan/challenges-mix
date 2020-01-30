package com.ivan.polovyi.challemges.examples;

import java.math.BigInteger;

public class MultithreadedCalculation {


    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {

        BigInteger result = null;

        PowerCalculatingThread powThread1 =
                new PowerCalculatingThread(base1, power1);

        PowerCalculatingThread powThread2 =
                new PowerCalculatingThread(base2, power2);
        powThread1.start();
        powThread2.start();

        powThread1.join();
        powThread2.join();

        result = powThread1.getResult().add(powThread2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
