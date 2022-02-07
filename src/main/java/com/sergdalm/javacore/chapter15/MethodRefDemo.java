package src.main.java.com.sergdalm.javacore.chapter15;

// Demonstrate a method reference for a static method.

import java.util.ArrayList;
import java.util.List;

// A functional interface for string operations.
interface StringFunc3 {
        String func(String n);
}

// This class defines a static method called strReverseEveryWord().
class MyStringOps {
    // A static method that reverses every word in a string.
    static String strReverseEveryWord(String str) {
        StringBuilder result = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        // Put words into ArrayList
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ')
                sb.append(str.charAt(i));
            else {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(!sb.toString().equals("")) list.add(sb.toString());

        // Reverse every word and append the into one string
        for(String s : list) {
            for(int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            // Add spaces between words, but not after the last word
            if(list.lastIndexOf(s) != list.size() - 1) result.append(' ');
        }

        return result.toString();
    }
}

public class MethodRefDemo {

    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed any instance
    // of that interface, including a method reference.
    static String stringOp(StringFunc3 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;

        // Here, a method reference to strReverseEveryWord is passed to stringOp().
        outStr = stringOp(MyStringOps::strReverseEveryWord, inStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
