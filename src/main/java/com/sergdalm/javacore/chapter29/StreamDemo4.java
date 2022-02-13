package src.main.java.com.sergdalm.javacore.chapter29;

// Map one stream to another.

import java.util.*;
import java.util.stream.*;

public class StreamDemo4 {
    public static void main(String[] args)  {
        // A list of double values.
        List<Double> myList = new ArrayList<>(Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0));

        // Map the square root of the elements in myList to a new stream.
        Stream<Double> sqrtRootStrm = myList.stream()
                .map(a -> Math.sqrt(a));

        // Find the product of the square roots.
        double productOfSqrRoots = sqrtRootStrm
                .reduce(1.0, (a,b) -> a * b);

        System.out.println("Product of square roots is " + productOfSqrRoots);
    }
}

