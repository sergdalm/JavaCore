package src.main.java.com.sergdalm.javacore.сhapter28;

// A simple example of Atomic.

import java.util.concurrent.atomic.*;

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}

class Shared2 {
    static AtomicInteger ai = new AtomicInteger(0);
}

// A thread od execution that increments count.
class AtomThread implements Runnable {
    String name;

    AtomThread(String n) {
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting " + name);

        for(int i = 1; i <= 3; i++) {
            System.out.println(name + " got: " + Shared2.ai.getAndSet(i));
        }

    }
}