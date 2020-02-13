package com.ivan.polovyi.challenges.input.output.stream;

import com.ivan.polovyi.challenges.FilesFromResourceFolder;

import java.io.*;


// copying file by bytes
public class CopyFileFileInputOutputStream {

    public static void main(String[] args) {
        FilesFromResourceFolder filesFromResourceFolder = new FilesFromResourceFolder();
        File source = filesFromResourceFolder.getByFileName("textExample.txt");
        File destination = new File(filesFromResourceFolder.getByFileName("//") + "outputFile.txt");

        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {

            int inData;
            while ((inData = in.read()) != -1) {
                out.write(inData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int compareTo = source.compareTo(destination);
        System.out.println("compareTo = " + compareTo);
    }
}
