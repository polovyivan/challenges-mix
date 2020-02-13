package com.ivan.polovyi.challenges;

import java.io.File;
import java.net.URL;

public class FilesFromResourceFolder {

    public File getByFileName(String filePath) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(filePath);

        if (resource == null) {
            throw new IllegalArgumentException("File not found");
        } else {
            return new File(resource.getFile());
        }


    }
}
