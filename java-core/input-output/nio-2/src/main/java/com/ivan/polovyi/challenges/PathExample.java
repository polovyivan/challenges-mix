package com.ivan.polovyi.challenges;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) throws URISyntaxException, IOException {

        ClassLoader classLoader = new PathExample().getClass().getClassLoader();

        String resource = classLoader.getResource("example.txt").getPath().substring(1);

        /*
       Path creation
         */
        Path path = Paths.get(resource);
        System.out.println("path = " + path);

        Path pathFromURI = Paths.get(classLoader.getResource("example.txt").toURI());
        System.out.println("pathFromURI = " + pathFromURI);

        /*
        Path is correct,
        but the problem is PC don't have a FileSystemProvider that is registered with the http scheme.
         */
        // Path pathFromURL = Paths.get(new URI("http://www.wiley.com"));
        // System.out.println("pathFromURL = " + pathFromURL);

        Path pathFromVarargs = Paths.get(resource.substring(0, 2), resource.substring(2).split("/"));
        System.out.println("pathFromVarargs = " + pathFromVarargs);


        // accessing underlying FileSystem
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println("fileSystem = " + fileSystem);

        Path fileSystemPath = fileSystem.getPath(resource);
        System.out.println("fileSystemPath = " + fileSystemPath);

        // File to Path

        File file = new File(resource);
        Path pathFromFile = file.toPath();
        System.out.println("pathFromFile = " + pathFromFile);

        // Path to File
        File fileFromPath = path.toFile();
        System.out.println("fileFromPath = " + fileFromPath);


       /*
       Path objects
        */

       // get count in path and get each name
        String pathToString = path.toString();
        System.out.println("pathToString = " + pathToString);

        int nameCount = path.getNameCount();
        System.out.println("nameCount = " + nameCount);

        for (int i = 0; i < nameCount; i++) {
            System.out.println("path.getName(i) = " + path.getName(i));
        }

        // File name, Parent, Root
        Path fileName = path.getFileName();
        System.out.println("fileName = " + fileName);

        Path parent = path.getParent();
        System.out.println("parent = " + parent);

        Path root = path.getRoot();
        System.out.println("root = " + root);

        // isAbsolute toAbsolutePath
        boolean isAbsolute = path.isAbsolute();
        System.out.println("isAbsolute = " + isAbsolute);

        Path toAbsolutePath = path.toAbsolutePath();
        System.out.println("toAbsolutePath = " + toAbsolutePath);

        // subPass
        Path subpath01 = path.subpath(0, 1);
        System.out.println("subpath01 = " + subpath01);
        Path subpath56 = path.subpath(5, 6);
        System.out.println("subpath56 = " + subpath56);

        //relativize, resolve, normalize, toRealPath
        Path path1 = Paths.get(classLoader.getResource("example2.txt").getPath().substring(1));
        Path relativize = path.relativize(path1);
        System.out.println("relativize = " + relativize);

        Path resolve = relativize.resolve(path);
        System.out.println("resolve = " + resolve);

        Path normalize = relativize.normalize();
        System.out.println("normalize = " + normalize);

        Path toRealPath = Paths.get(".").toRealPath();
        System.out.println("toRealPath (current working directory) = " + toRealPath);





    }
}
