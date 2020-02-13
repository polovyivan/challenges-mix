package com.ivan.polovyi.challenges.serialization;

import com.ivan.polovyi.challenges.FilesFromResourceFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDeserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tommy tiger", 5, 'T', "transient", 1));
        animals.add(new Animal("Peter Penguin", 8, 'P', "transient", 2));

        FilesFromResourceFolder filesFromResourceFolder = new FilesFromResourceFolder();
        File dataFile = new File(filesFromResourceFolder.getByFileName("//") + "animals.data");
        String path = dataFile.getAbsolutePath();

        System.out.println("path = " + path);
        serializeAnimals(animals, dataFile);
        System.out.println(getAnimals(dataFile));

    }

    private static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {

            while (true) {

                Object object = in.readObject();
                if (object instanceof Animal) {
                    animals.add((Animal) object);
                }

            }


        } catch (EOFException e) {

        }
        return animals;
    }

    private static void serializeAnimals(List<Animal> animals, File dataFile) throws IOException {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal : animals) {
                out.writeObject(animal);
            }
        }
    }


    static class Animal implements Serializable {

        private static final long serialVersionUID = 181200279258329532L;

        private String name;
        private int age;
        private char type;
        // transient won't be serialized
        private transient String transientVariable;
        // as it belongs to a class not object it will be always as value of first object created
        private static int staticVariable;

        public Animal(String name, int age, char type, String transientVariable, int staticVariable) {
            this.name = name;
            this.age = age;
            this.type = type;
            this.transientVariable = transientVariable;
            this.staticVariable = staticVariable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }

        public String getTransientVariable() {
            return transientVariable;
        }

        public void setTransientVariable(String transientVariable) {
            this.transientVariable = transientVariable;
        }

        public static int getStaticVariable() {
            return staticVariable;
        }

        public static void setStaticVariable(int staticVariable) {
            Animal.staticVariable = staticVariable;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", type=" + type +
                    ", transientVariable='" + transientVariable + '\'' +
                    ", staticVariable='" + staticVariable + '\'' +
                    '}';
        }
    }
}
