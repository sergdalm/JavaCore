package src.main.java.com.sergdalm.javacore.chapter29;

// Demonstrate trySplit().
import java.util.*;
import java.util.stream.*;

public class StreamDemo10 {
    public static void main(String[] args) {
        // Create a list of Strings.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();

        // Obtain a Spliterator.
        Spliterator<String> splitItr = myStream.spliterator();

        // Now, split the first iterator.
        Spliterator<String> splitIter2 = splitItr.trySplit();

        // If splitItr could be split, use splitItr2 first.
        if(splitIter2 != null){
            System.out.println("Output from splitIter2: ");
            splitIter2.forEachRemaining((n) -> System.out.println(n));
        }

        // Now, use the splitItr.
        System.out.println("\nOutput from splitIter: ");
        splitItr.forEachRemaining((n) -> System.out.println(n));

    }
}
