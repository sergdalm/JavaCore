package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate ByteArrayOutputStream.
// This program uses try-with-resources. It requires JDK 7 or later.

import java.io.*;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This should end up in the array";
        byte[] buf = s.getBytes();

        try {
            f.write(buf);
        } catch(IOException e) {
            System.out.println("Error writing to buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("into array");
        byte[] b = f.toByteArray();
        for(int i = 0; i < b.length; i++)
            System.out.print((char) b[i]);

        System.out.println("\nTo an OutputStream()");

        // Use try-with-resources to manage the file stream.
        try(FileOutputStream f2 = new FileOutputStream("text.txt")) {
            f.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }

        System.out.println("Doing a reset");
        f.reset();
        for(int i = 0; i < 3; i++)
            f.write('X');

        System.out.println(f.toString());
    }
}
