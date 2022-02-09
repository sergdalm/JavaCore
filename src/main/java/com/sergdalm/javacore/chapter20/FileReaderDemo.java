package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate FileReader.
// This program uses try-with-resources. It requires JDK 7 or later.

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("src/main/java/com/sergdalm/javacore/chapter20/FileReaderDemo.java")) {
            int c;

            // Read and display the file.
            while((c = fr.read()) != -1)
                System.out.print((char) c);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
