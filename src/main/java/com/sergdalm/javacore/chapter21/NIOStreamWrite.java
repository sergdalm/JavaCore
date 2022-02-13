package src.main.java.com.sergdalm.javacore.chapter21;

// Demonstrate NIO-based, stream output. Requires JDK 7 or later.

import java.io.*;
import java.nio.file.*;

public class NIOStreamWrite {
    public static void main(String[] args) {
        // Open the file and obtain a stream linked to it.
        try(OutputStream fout = new BufferedOutputStream(
                Files.newOutputStream(Paths.get("resources/alphabet.txt")))) {

            // Write some bytes to the stream.
            for(int  i = 0; i < 26; i++)
                fout.write((byte) ('a' + i));

        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
