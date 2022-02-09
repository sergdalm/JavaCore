package src.main.java.com.sergdalm.javacore.chapter20;

// Demonstrate Console.

import java.io.*;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        // Obtain a reference to the console.
        con = System.console();
        // If no console available, exit.
        if(con == null) return;

        // Read a string and then display it.
        str = con.readLine("Enter a string: ");
        con.printf("Here is your string : %s\n", str);
    }
}
