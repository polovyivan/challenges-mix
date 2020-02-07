package com.ivan.polovyi.challenges;

public class InnerInterfaceExample {

    public static void main(String[] args) {
        new InnerInterfaceExample().new DontTell().shh();

    }

    private interface Secret {
        public void shh();
    }

    class DontTell implements Secret {

        @Override
        public void shh() {
            System.out.println("Secret shh...");
        }
    }
}
