package com.ivan.polovyi.challenges.reader.writer;

import com.ivan.polovyi.challenges.FilesFromResourceFolder;

import java.io.*;

public class CopyFileFileReaderFileWriter {

    public static void main(String[] args) {
        FilesFromResourceFolder filesFromResourceFolder = new FilesFromResourceFolder();


        File source = filesFromResourceFolder.getByFileName("textExample.txt");
        File destination = new File(filesFromResourceFolder.getByFileName("//") + "buffered_output.txt");

        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {

            String s;
            while ((s = in.readLine()) != null) {
                System.out.println("s = " + s);
                out.write(s);
                out.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
