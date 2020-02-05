package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonExampleTest {

    @Test
    void getInstance() {
        assertEquals(SingletonExample.getInstance().toString(), SingletonExample.getInstance().toString());
    }
}