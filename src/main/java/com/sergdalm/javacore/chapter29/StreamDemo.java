package src.main.java.com.sergdalm.javacore.chapter29;

// Demonstrate several stream operations.

import java.util.*;
import java.util.stream.*;


public class StreamDemo {
    public static void main(String[] args) {
        // Create a list of Integer values.
        List<Integer> myList = Arrays.asList(7, 18, 10, 24, 17, 5);

        System.out.println("Original list:" + myList);

        // Obtain a Stream to the ArrayList
        Stream<Integer> myStream = myList.stream();

        // Obtain the minimum and maximum values by use of min(),
        // max(), isPresent, and get().
        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Minimum value: " + integer));


        // Must obtain a new stream because previous call to min()
        // is a terminal operation that consumed the stream.
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("Maximum value: " + integer));

        // Sort the stream by use of sorted().
        Stream<Integer> sortedStream = myList.stream().sorted();

        //Display sorted stream by use of forEach();
        System.out.print("Sorted stream: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // Display only the odd values by use of filter().
        Stream<Integer> oddValues = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Odd values: ");
        oddValues.forEach((n) -> System.out.print(n + " "));
        System.out.println();


        // Display only odd values that greater than 5.
        System.out.print("Odd values greatest than 5: ");
        myList.stream()
                .sorted()
                .filter(n -> (n % 2) == 1)
                .filter(n -> n > 5)
                .forEach(n -> System.out.print(n + " "));
    }
}

