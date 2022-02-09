package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate CharArrayWriter.
// This program uses try-with resources. It requires JDK 7 or later.

import java.io.*;

public class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException{
        CharArrayWriter f = new CharArrayWriter();
        String s = "This should end up in the array";
        char[] buf = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);

        try {
            f.write(buf);
        } catch(IOException e) {
            System.out.println("Error writing to buffer");
        }

        System.out.println("Buffer as string");
        System.out.println(f.toString());
        System.out.println("Into array");

        char[] c = f.toCharArray();
        for(char ch : c)
            System.out.print(ch);

        System.out.println("\nTo a FileWriter()");

        // Use try-with-resources to manage the file stream.
        try(FileWriter f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("Doing a reset");
        f.reset();

        for(int i = 0; i < 3; i++)
            f.write('X');

        System.out.println(f.toString());
    }
}
