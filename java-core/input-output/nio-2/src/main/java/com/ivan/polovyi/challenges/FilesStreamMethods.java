package com.ivan.polovyi.challenges;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesStreamMethods {
    public static void main(String[] args) {
        Path path = null;
        try {
            path = Paths.get(".").toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("path = " + path);

        // walk
        try {
            Files.walk(path)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // find()
        String filePath = "W:\\projetos\\coding-challenges\\java-core\\input-output\\nio-2\\src\\main\\java\\com\\ivan\\polovyi\\challenges";
        try {

            Files.find(Paths.get(
                    filePath), 10, (p, a) -> p.toString().endsWith(".java")
                    && a.lastModifiedTime().toMillis() > 1400L)
                    .map(s -> " arquivo = ".concat(s.toString()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // list files in directory
        try {
            Files.list(Paths.get(filePath))
                    .map(s -> "list " + s.toString())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassLoader classLoader = new PathExample().getClass().getClassLoader();
        String resource = classLoader.getResource("example.txt").getPath().substring(1);

        Path path1 = Paths.get(resource);
        System.out.println("path1 = " + path1);

        try {
            Files.lines(path1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
