package com.ivan.polovyi.challenges;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public class FileExample {

    public static void main(String[] args) {

        FilesFromResourceFolder resourceFolder = new FilesFromResourceFolder();

        File file = resourceFolder.getByFileName("textExample.txt");

        // bellow code adds %5c don't know why
        System.out.println(resourceFolder.getByFileName(System.getProperty("file.separator")));
        System.out.println(resourceFolder.getByFileName(File.separator));

        File dirPath = resourceFolder.getByFileName("//");
        System.out.println("dirPath = " + dirPath);


        boolean exists = file.exists();
        System.out.println("exists = " + exists);

        String name = file.getName();
        System.out.println("name = " + name);

        long lastModified = file.lastModified();
        System.out.println("lastModified = " + lastModified);

        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);

        boolean isFile = file.isFile();
        System.out.println("isFile = " + isFile);

        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);

        try {
            String canonicalPath = file.getCanonicalPath();
            System.out.println("canonicalPath = " + canonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = file.toPath();
        System.out.println("path = " + path);

        URI uri = file.toURI();
        System.out.println("uri = " + uri);

        long length = file.length();
        System.out.println("length = " + length);

        boolean canExecute = file.canExecute();
        System.out.println("canExecute = " + canExecute);

        boolean canRead = file.canRead();
        System.out.println("canRead = " + canRead);

        boolean canWrite = file.canWrite();
        System.out.println("canWrite = " + canWrite);

        // create new directory Object
        File newDir = new File(dirPath + "//newFolder");

        // create new directory
        boolean newDirCreated = newDir.mkdir();
        System.out.println("newDirCreated = " + newDirCreated);

        boolean newDirExists = newDir.exists();
        System.out.println("newDirExists = " + newDirExists);

        String newDirPath = newDir.getPath();
        System.out.println("newDirPath = " + newDirPath);


        File fileTest = new File(newDirPath + "//textExample3.txt");
        try {
            boolean newFile = fileTest.createNewFile();
            System.out.println("newFile = " + newFile);
            System.out.println("fileTest.getPath() = " + fileTest.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // list all files in directory
        for (File f : dirPath.listFiles()) {
            System.out.println("f = " + f);
        }


        for (File ff : dirPath.listFiles(fil -> fil.getName().contains(".txt"))) {
            System.out.println("ff = " + ff);
        }

        File renamed = new File(newDirPath + "//textExampleRenamed.txt");
        boolean renameTo = fileTest.renameTo(renamed);
        System.out.println("renameTo = " + renameTo);
        System.out.println("fileTest = " + fileTest.getName());

        int compareTo = fileTest.compareTo(file);
        System.out.println("compareTo = " + compareTo);

        System.out.println("fileTest = " + fileTest.getPath());

        boolean delete = fileTest.delete();
        System.out.println("delete = " + delete);

        boolean delete1 = renamed.delete();
        System.out.println("delete = " + delete1);

    }

}
