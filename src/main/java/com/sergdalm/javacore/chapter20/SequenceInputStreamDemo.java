package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate sequenced input.

import java.io.*;
import java.util.*;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    public FileInputStream nextElement() {
        try {
            System.out.println();
            return new FileInputStream(files.nextElement().toString());
        } catch(IOException e) {
            return null;
        }
    }
}

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<String>();
        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);

        try(InputStream input = new SequenceInputStream(ise)) {
            while((c = input.read()) != -1)
                System.out.print((char) c);
        } catch (NullPointerException e) {
            System.out.print("ErrorOpening File");
        } catch(IOException e) {
            System.out.print("I/O Error: " + e);
        }
    }
}
