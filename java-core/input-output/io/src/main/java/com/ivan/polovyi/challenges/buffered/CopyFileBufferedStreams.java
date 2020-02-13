package com.ivan.polovyi.challenges.buffered;

import com.ivan.polovyi.challenges.FilesFromResourceFolder;

import java.io.*;

/* reads nad writes by portions stored in the buffer
   much faster then traditional FileStream
 */

public class CopyFileBufferedStreams {

    public static void main(String[] args) {
        FilesFromResourceFolder filesFromResourceFolder = new FilesFromResourceFolder();


        File source = filesFromResourceFolder.getByFileName("textExample.txt");
        File destination = new File(filesFromResourceFolder.getByFileName("//") + "buffered_output.txt");

        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[1024];
            int lengthRead;

            while ((lengthRead = in.read(buffer)) > 0) {

                out.write(buffer, 0, lengthRead);
                out.flush();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(source.compareTo(destination));
    }
}
