package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonThreadSaveTest {

    @Test
    void getInstance() {
        assertEquals(SingletonThreadSave.getInstance().toString(), SingletonThreadSave.getInstance().toString());
    }
}