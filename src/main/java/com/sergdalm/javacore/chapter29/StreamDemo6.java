package src.main.java.com.sergdalm.javacore.chapter29;

// Map a Stream to an IntStream.

import java.util.*;
import java.util.stream.*;

public class StreamDemo6 {
    public static void main(String[] args) {
        // A list of double values.
        List<Double> myList = new ArrayList<>(Arrays.asList(1.1, 3.6, 9.2, 4.7, 12.1, 5.0));

        System.out.print("Original values in myList: ");
        myList.stream()
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        // Map the ceiling of the elements in myList to an IntStream.
        IntStream cStrm = myList.stream()
                .mapToInt(d -> (int) Math.ceil(d));

        System.out.print("The ceiling of the values in myList: ");
        cStrm.forEach(a -> System.out.print(a + " "));
    }
}

