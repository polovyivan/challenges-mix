package com.ivan.polovyi.challenges;

// this example can be used with an interface instead of abstract class
public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        AnonymousInnerClassExample anonymousInnerClassExample = new AnonymousInnerClassExample();
        int admission = anonymousInnerClassExample.admission(100);
        System.out.println("admission = " + admission);
    }

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }
}
