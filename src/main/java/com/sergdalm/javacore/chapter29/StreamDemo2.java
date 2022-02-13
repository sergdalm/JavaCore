package src.main.java.com.sergdalm.javacore.chapter29;


import java.util.*;
import java.util.stream.*;

// Demonstrate the reduce() method.

public class StreamDemo2 {
    public static void main(String[] args) {
        // Create a list of Integer values.
        List<Integer> myList =  Arrays.asList(7, 18, 10, 24, 17, 5);

        // Two ways to obtain the integer product of the element
        // in myList by use of reduce().
        Optional<Integer> productObj = myList.parallelStream()
                .reduce((a,b) -> a * b);
        if(productObj.isPresent()) System.out.println("Product as Optional: " + productObj.get());


        int product = myList.stream()
                .reduce(1, (a,b) -> a * b);
        System.out.println("Product as int: " + product);

    }
}

