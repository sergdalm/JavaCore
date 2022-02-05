package src.main.java.com.sergdalm.javacore.chapter11;

/*
    This variation of the ShowFile program
    uses a try-with-resources statement
    to automatically close a file after
    it is no longer needed.

    Note: This code requires JDK 7.
 */

import java.io.*;

class ShowFile2 {
    public static void main(String[] args) throws IOException {
        int i;

        // First, confirm that a file name has been specified.
        if(args.length != 1) {
            System.out.println("Usage: ShowFile2 filename");
            return;
        }

        // The following code uses try-with-resources statement to open
        // a file and then automatically close it when the try block is left.
        try (FileInputStream fin = new FileInputStream(args[0])){
            do {
                i = fin.read(); // Read from the file
                if(i != -1) System.out.print((char) i);
            } while(i != -1);

        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
        } catch (IOException exc) {
            System.out.println("An I/O Error Occurred.");
        }
    }
}

