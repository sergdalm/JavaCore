package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate DataInputStream and DataOutputStream.
// This program uses try-with-resources. It requires JDK 7 or later.

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {

        // First, write the data.
        try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open output file");
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // Now, read the data back.
        try(DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Here are the values: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open input file");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
