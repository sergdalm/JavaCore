package src.main.java.com.sergdalm.javacore.chapter11;

// Create multiple threads.

class NewThread2 implements Runnable {
    String name; // name of thread
    Thread t;

    NewThread2(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start(); // Start the thread
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting.");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("One"); // start threads
        new NewThread2("Two");
        new NewThread2("Three");

        try {
            // wait for other thread to end
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
