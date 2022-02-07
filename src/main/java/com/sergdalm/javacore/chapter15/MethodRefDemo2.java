package src.main.java.com.sergdalm.javacore.chapter15;

// Demonstrate a method reference to an instance method

// A functional interface for string operations.
interface StringFunc4 {
    String func(String n);
}

// Now, this class defines as instance method called strReverse().
class MyStringOps2 {
    String strReverser(String str) {
        String result = "";
        int i;

        for( i = str.length() - 1; i >= 0; i --)
            result += str.charAt(i);

        return result;
    }
}

public class MethodRefDemo2 {

    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed any instance
    // of that interface, including method references.
    static String stringOp(StringFunc4 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas ass power to Java";
        String outStr;

        // Create a MyStringOps object
        MyStringOps2 strOps2 = new MyStringOps2();

        // Now, a method reference to the instance method strReverse
        // is passed to stringOp().
        outStr = stringOp(strOps2::strReverser, inStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
