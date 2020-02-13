package com.ivan.polovyi.challenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        ClassLoader classLoader = new PathExample().getClass().getClassLoader();

        String resource = classLoader.getResource("example.txt").getPath().substring(1);

        String resource2 = classLoader.getResource("example2.txt").getPath().substring(1);

        Path path1 = Paths.get(resource);
        System.out.println("path1 = " + path1);

        Path path2 = Paths.get(resource2);
        System.out.println("path2 = " + path2);


        boolean exists = Files.exists(path1);
        System.out.println("exists = " + exists);
        boolean doesNotExists = Files.exists(Paths.get("does not exists"));
        System.out.println("doesNotExists = " + doesNotExists);

        // check if 2 paths relate to the same file within the system
        try {
            boolean sameFile = Files.isSameFile(path1, path2);
            System.out.println("sameFile = " + sameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create directory
        Path directory = null;
        try {
            String newDir = Paths.get(resource).getParent() + "/onedir";
            if (!Files.exists(Paths.get(newDir))) {
                directory = Files.createDirectory(Paths.get(newDir));
            }
            System.out.println("directory = " + directory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // directories
        Path directories = null;
        try {
            directories = Files.createDirectories((Paths.get(Paths.get(resource).getParent() + "/morethendir/dir1/dir2")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("directories = " + directories);


        // copy file
        Path copy = null;
        try {
            copy = Files.copy(path2, Paths.get(Paths.get(resource).getParent() + "/copiedFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("copy = " + copy);

        // move file
        Path move = null;
        try {
            move = Files.move(copy, Paths.get(directories + "/copiedFile.txt"));
        } catch (IOException e) {

        }
        System.out.println("move = " + move);

        boolean deleteIfExists = false;
        try {
            deleteIfExists = Files.deleteIfExists(move);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("deleteIfExists = " + deleteIfExists);


        // reading and writing file data with newBufferedReader/Writer
        try (BufferedReader in = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String currentLine = null;
            while ((currentLine = in.readLine()) != null) {
                System.out.println("currentLine = " + currentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter out = Files.newBufferedWriter(Paths.get(directories + "/new_file_buffered_writer.txt"))) {

            out.write("New File");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // read all lines
        List<String> readAllLines = null;
        try {
            readAllLines = Files.readAllLines(path1, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("readAllLines = " + readAllLines);



        /*
        File attributes
         */
        // accessing one by one
        boolean isDirectory = Files.isDirectory(path1);
        System.out.println("isDirectory = " + isDirectory);

        boolean regularFile = Files.isRegularFile(path1);
        System.out.println("regularFile = " + regularFile);

        boolean symbolicLink = Files.isSymbolicLink(path1);
        System.out.println("symbolicLink = " + symbolicLink);

        boolean readable = Files.isReadable(path1);
        System.out.println("readable = " + readable);

        boolean executable = Files.isExecutable(path1);
        System.out.println("executable = " + executable);

        long size = 0;
        try {
            size = Files.size(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("size = " + size);

        FileTime lastModifiedTime = null;

        try {
            lastModifiedTime = Files.getLastModifiedTime(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("lastModifiedTime = " + lastModifiedTime);

        UserPrincipal owner = null;
        try {
            owner = Files.getOwner(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("owner = " + owner);

//        Path setOwner = null;
//        try {
//            setOwner = Files.setOwner(path1,
//                    path1.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName(owner.getName()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("setOwner = " + setOwner);



        /*
        BasicFileAttributes
         */
        BasicFileAttributes basicFileAttributes = null;
        try {
            basicFileAttributes = Files.readAttributes(path1, BasicFileAttributes.class);
        } catch (IOException e) {

        }
        FileTime creationTime = basicFileAttributes.creationTime();
        System.out.println("creationTime = " + creationTime);

        Object fileKey = basicFileAttributes.fileKey();
        System.out.println("fileKey = " + fileKey);

        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println("lastAccessTime = " + lastAccessTime);

        boolean isDirectory1 = basicFileAttributes.isDirectory();
        System.out.println("isDirectory1 = " + isDirectory1);

        boolean other = basicFileAttributes.isOther();
        System.out.println("other = " + other);

        boolean regularFile1 = basicFileAttributes.isRegularFile();
        System.out.println("regularFile1 = " + regularFile1);

        boolean symbolicLink1 = basicFileAttributes.isSymbolicLink();
        System.out.println("symbolicLink1 = " + symbolicLink1);

        FileTime fileTime = basicFileAttributes.lastModifiedTime();
        System.out.println("fileTime = " + fileTime);

        long size1 = basicFileAttributes.size();
        System.out.println("size1 = " + size1);

        /*
        Attribute view
         */

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path1, BasicFileAttributeView.class);

        FileTime lastModifiedFile = FileTime.fromMillis(fileTime.toMillis() + 10_000);
        System.out.println("lastModifiedTime = " + fileTime);
        try {
            fileAttributeView.setTimes(lastModifiedFile, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Files.getLastModifiedTime(path1); = " + Files.getLastModifiedTime(path1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
