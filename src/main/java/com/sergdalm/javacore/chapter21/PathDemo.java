package src.main.java.com.sergdalm.javacore.chapter21;

// Obtain information about a path and file.
// Requires JDK 7 or later.

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("resources/text.txt");
        System.out.println("File Name: " + filepath.getName(1));
        System.out.println("Path: " + filepath);
        System.out.println("Absolute Path: " + filepath.toAbsolutePath());
        System.out.println("Parent: " + filepath.getParent());

        if(Files.exists(filepath))
            System.out.println("File exists");
        else
            System.out.println("File does not exist");

        try {
            if(Files.isHidden(filepath))
                System.out.println("File is hidden");
            else
                System.out.println("File is not hidden");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        if(Files.isReadable((filepath)))
            System.out.println("File is readable");

        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);

            if(attributes.isDirectory())
                System.out.println("The file is a directory");
            else
                System.out.println("The file is not directory");

            if(attributes.isRegularFile())
                System.out.println("The file is a normal file");
            else
                System.out.println("The file is not a normal file");

            if(attributes.isSymbolicLink())
                System.out.println("The file is a symbolic link");
            else
                System.out.println("The file is not a symbolic link");

            System.out.println("File last modified: " + attributes.lastModifiedTime());
            System.out.println("File size: " + attributes.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("Error reading attributes: " + e);
        }


    }
}
