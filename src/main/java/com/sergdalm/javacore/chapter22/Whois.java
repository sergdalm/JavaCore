package src.main.java.com.sergdalm.javacore.chapter22;

// Demonstrates Sockets.

import java.net.*;
import java.io.*;

public class Whois {
    public static void main(String[] args) throws Exception {
        int c;

        // Create a socket connected to internic.net, port 43. Manage this
        // socked with a try-with-resources block.
        // Obtain input nad output streams.
        Socket s = new Socket("whois.internic.net", 43);
        try(InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream()) {
            // Construct a request string.

            String str = (args.length == 0 ? "MHProfessional.com" : args[0] + "\n");
            // Convert to bytes.
            byte buf[] = str.getBytes();

            // Send request.
            out.write(buf);

            // Read and display response.
            while((c = in.read()) != -1) {
                System.out.println((char) c);
            }
        }
    }
}
