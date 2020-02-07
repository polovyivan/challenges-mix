package com.ivan.polovyi.challenges;

public class MemberInnerClass {
    private int repeat = 4;


    public static void main(String[] args) {

        MemberInnerClass memberInnerClass = new MemberInnerClass();
        memberInnerClass.new Inner("Ola").go();

        new MemberInnerClass().new Inner("Oi").go();

    }

    protected class Inner {

        public String greeting;

        public Inner(String greeting) {
            this.greeting = greeting;
        }

        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println("greeting = " + greeting);
            }
        }
    }


}