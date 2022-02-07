package src.main.java.com.sergdalm.javacore.chapter15;

// Demonstrate a constructor reference
// and constructor reference for an array.

// MyFunc3 is a functional interface whose method returns
// a MyClass reference.
interface MyFunc3 {
    MyClass1 func(int n);
}

interface MyArrayCreator<T> {
    T func(int n);
}

class MyClass1 {
    private int val;

    // This constructor takes an argument.
    MyClass1(int v) {
        val = v;
    }

    // This is the default constructor.
    MyClass1() {
        val = 0;
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {

        // Create a reference to the MyClass1 constructor.
        // Because func() in MyFunc takes an argument, new
        // refers to the parameterized constructor in MyClass,
        // not the default constructor.
        MyFunc3 myClassCons = MyClass1::new;

        // Create an instance of MyClass via that constructor reference.
        MyClass1 mc = myClassCons.func(100);

        // Use the instance of MyClass just created.
        System.out.println("val in mc is " + mc.getVal());

        // Example of creating a new array using a constructor reference for an array.
        MyArrayCreator<MyClass1[]> mcArrayCons = MyClass1[]::new;
        MyClass1[] a = mcArrayCons.func(2);
        a[0] = new MyClass1(1);
        a[1] = new MyClass1(2);
    }
}

