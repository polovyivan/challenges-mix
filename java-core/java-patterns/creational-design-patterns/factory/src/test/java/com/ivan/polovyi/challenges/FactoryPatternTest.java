package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class FactoryPatternTest {

    @Test
    void getFood() {

        assertEquals("com.ivan.polovyi.challenges.Pellets", FactoryPattern.getFood("goat").getClass().getName());
        assertEquals("com.ivan.polovyi.challenges.Pellets", FactoryPattern.getFood("rabbit").getClass().getName());
        assertEquals("com.ivan.polovyi.challenges.Hay", FactoryPattern.getFood("zebra").getClass().getName());
        assertEquals("com.ivan.polovyi.challenges.Fish", FactoryPattern.getFood("polar bear").getClass().getName());

    }
}