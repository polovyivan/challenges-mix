package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonStaticInitializationTest {

    @Test
    void getInstance() {
        assertEquals(SingletonStaticInitialization.getInstance().toString(), SingletonStaticInitialization.getInstance().toString());
    }
}