package src.main.java.com.sergdalm.javacore.chapter21;

// Display a directory. Requires JDK 7 or later.

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DirList {
    public static void main(String[] args) {
        String dirname = "resources";

        // Create a filter that returns true only for writable files.
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<>() {
            public boolean accept(Path filename) {
                if(Files.isWritable(filename)) return true;
                return false;
            }
        };
        // Obtain and manage a directory stream within a try block.
        try(DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {
            System.out.println("Directory of " + dirname);

            // Because DirectoryStream implements Iterable, we
            // can use a "foreach" loop to display the directory.
            for(Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if(attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");

                System.out.println(entry.getName(1));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (NotDirectoryException e ) {
            System.out.println(dirname + " is not a directory");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
