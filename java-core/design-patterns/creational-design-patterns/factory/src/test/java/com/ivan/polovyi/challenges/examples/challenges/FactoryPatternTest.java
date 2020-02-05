package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class FactoryPatternTest {

    @Test
    void getFood() {

        assertEquals("Pellets", FactoryPattern.getFood("goat").getClass().getName());
        assertEquals("Pellets", FactoryPattern.getFood("rabbit").getClass().getName());
        assertEquals("Hay", FactoryPattern.getFood("zebra").getClass().getName());
        assertEquals("Fish", FactoryPattern.getFood("polar bear").getClass().getName());

    }
}