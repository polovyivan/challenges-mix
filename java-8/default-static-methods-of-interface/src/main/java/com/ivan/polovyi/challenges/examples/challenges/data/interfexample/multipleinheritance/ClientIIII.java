package com.ivan.polovyi.challenges.examples.challenges.data.interfexample.multipleinheritance;

public class ClientIIII implements InterfaceI, InterfaceII, InterfaceIII {
    public void methodA() {
        System.out.println("Method A " + InterfaceIII.class);
    }

    public static void main(String[] args) {
        ClientIIII cq = new ClientIIII();
        cq.methodA();
        cq.methodB();
        cq.methodC();
    }
}
