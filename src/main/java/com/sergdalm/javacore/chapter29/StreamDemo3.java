package src.main.java.com.sergdalm.javacore.chapter29;

// Demonstrate the use of a combiner with reduce().

import java.util.*;
import java.util.stream.*;

public class StreamDemo3 {
    public static void main(String[] args)  {
        // This is now a list of double value.
        ArrayList<Double> myList = new ArrayList<>(Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0));

        double productOfSqrRoots = myList.parallelStream()
                .reduce(1.0,
                        (a,b) -> a * Math.sqrt(b),
                        (a,b) -> a * b);
        System.out.println("Product of square roots: " + productOfSqrRoots);



    }
}

