package src.main.java.com.sergdalm.javacore.chapter21;

// Use Channel I/O to read a file. Requires 7 or later.

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        // Obtain a path to the file and obtain a channel to that file within a try-with-resources bloc
        // Here, the channel is opened on the Path returned by Paths.get()
        try(SeekableByteChannel fChan = Files.newByteChannel(Paths.get("resources/text.txt"))) {

            // Allocate a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(128);
             do {
                 // Read a buffer
                 count = fChan.read(mBuf);

                 // Stop when end of file is reached.
                 if(count != -1) {

                     // Rewind the buffer so that it can be read.
                     mBuf.rewind();

                     // Read bytes from the buffer and show
                     // them on the screen as characters.
                     for(int i = 0; i < count; i++)
                         System.out.print((char) mBuf.get());
                 }
             } while(count != -1);
            System.out.println();
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch(IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
