package src.main.java.com.sergdalm.javacore.chapter13;
// Display a text file.

// java ShowFile TEST.TXT

import java.io.*;
public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        // First, confirm that a filename has been specified.
        if(args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        // Attempt to open the file.
        try {
            fin = new FileInputStream(args[0]);


        //At this point, the file is open and can be read
        // The following reads characters until EOF is encountered.
            do {
                i = fin.read();
                if(i != -1) System.out.println((char) i);
            } while(i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: ");
        }

        // Close the file.
        finally {
            // Close file in all cases.
            try {
                if(fin != null) fin.close();
            } catch(IOException e) {
                System.out.println("Error closing file");
            }
        }

    }
}
