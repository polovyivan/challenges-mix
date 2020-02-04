package com.ivan.polovyi.chellenges;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableObject { // has to be final

    /*
    all variables have to be private and final
     */
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    /*
    has to have public constructor,
    and is an only way to create object.
    Constructor may have some condition to validate inputs
     */

    public ImmutableObject(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;

        if (favoriteFoods == null) {

            throw new RuntimeException("favorite food is required");
        }

        /*to avoid mutability of a list always create a copy of a passed input
        this way caller won't be able to do favoriteFoods.clean(),
        because this.favoriteFoods and favoriteFoods will point to different objects
        */

        this.favoriteFoods = new ArrayList<>(favoriteFoods);

    }


    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    /*
    when return here return a copy of an actual object
     */
    public List<String> getFavoriteFoods() {
        return new ArrayList<>(favoriteFoods);
    }
}
