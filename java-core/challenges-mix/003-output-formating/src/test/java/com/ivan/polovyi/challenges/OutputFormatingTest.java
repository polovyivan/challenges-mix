package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputFormatingTest {

    private static PrintStream sysOut;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void revertStreams() {
        System.setOut(sysOut);
    }


    @Test
    public void outputFormating() {
        String[] input = {"java 100", "cpp 65", "python 50"};
        OutputFormating.sysOut(input);
        assertEquals("================================\r\n" +
                "java        100\r\n" +
                "cpp         065\r\n" +
                "python      050\r\n" +
                "================================\r\n", outContent.toString());

    }


}