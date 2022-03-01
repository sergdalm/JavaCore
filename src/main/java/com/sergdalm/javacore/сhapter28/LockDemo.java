package src.main.java.com.sergdalm.javacore.сhapter28;

// A simple lock example.

import java.util.concurrent.locks.*;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

// A thread of execution that increments count.
class Shared1 {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        try {
            // First, lock count.
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " is locking count.");

            Shared1.count++;
            System.out.println(name + ": " + Shared1.count);

            // Now, allow a context switch -- if possible
            System.out.println(name + " is sleeping.");

            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            // Unlock
            System.out.println(name + " is unlocking count.");
            lock.unlock();
        }
    }

}