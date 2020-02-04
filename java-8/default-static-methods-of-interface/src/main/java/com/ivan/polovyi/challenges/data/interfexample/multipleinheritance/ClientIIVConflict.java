package com.ivan.polovyi.challenges.data.interfexample.multipleinheritance;

// give an error because interfaces has identical methods
//to resolve is to override it
//public class ClientIIVConflict implements InterfaceI,InterfaceIV {
//}

public class ClientIIVConflict implements InterfaceI, InterfaceIV {
    @Override
    public void methodA() {
        System.out.println("Implemented");
    }
}
