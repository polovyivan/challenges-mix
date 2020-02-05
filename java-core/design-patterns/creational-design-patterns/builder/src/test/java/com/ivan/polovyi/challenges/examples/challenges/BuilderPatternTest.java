package com.ivan.polovyi.challenges.examples.challenges;

import com.ivan.polovyi.challenges.examples.challenges.twoclasses.Animal;
import com.ivan.polovyi.challenges.examples.challenges.twoclasses.BuilderPattern;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BuilderPatternTest {

    @Test
    void build() {

        Animal duck = new BuilderPattern()
                .setAge(5)
                .setFavoriteFoods(Arrays.asList("grass"))
                .setSpecies("duck")
                .build();

        assertEquals("duck", duck.getSpecies());
    }
}