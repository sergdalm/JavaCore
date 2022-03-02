package src.main.java.com.sergdalm.javacore.сhapter28;

// This program helps to choose who is the cutest: cat or puppy.
// It uses two threads and Paterson lock to synchronize them.
// In this implementation win the thread on which method start() is called forst.

import java.util.concurrent.atomic.AtomicReference;

/**
 * Three criteria of Paterson lock:
 * - mutual exclusion (critical section is completed only one time)
 * - progress (at least one thread is running)
 * - bounded waiting
 */

public class PatersonLockDemo {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Hwo is the cutest?");
        String[] animals = {"Cat", "Puppy"};
        AtomicReference<String> result = new AtomicReference<>();

        PatersonLock lock = new PatersonLock();

        // PatersonLock is used to make only one thread
        // define the result.
        // Thus, only one thread enters critical section and defines the result.
        Thread t1 = new Thread(() -> {
            lock.flag0 = true;
            lock.turn = 0;

            // if t2 initialized lock's variables first,
            // this thread is waiting
            while(lock.flag1 == true && lock.turn == 1) {
                // busy wait
            }

            // critical section
            // Define the result only if it is not defined already.
            result.compareAndSet(null, animals[0]);

            // Set flag to 'false' to let another thread leave waiting section and terminate.
            lock.flag0 = false;
        });

        Thread t2 = new Thread(() -> {
            lock.flag1 = true;
            lock.turn = 1;

            // if t2 initialized lock's variables first,
            // this thread is waiting
            while(lock.flag0 == true && lock.turn == 0) {
                // busy wait
            }

            // critical section
            // Define the result only if it is not defined already.
            result.compareAndSet(null, animals[1]);

            // Set flag to 'false' to let another thread leave waiting section and terminate.
            lock.flag0 = false;
        });

        t2.start();
        t1.start();


        t1.join();
        t2.join();

        System.out.println(result + "!");
    }

    static void execute() {

    }
}

class PatersonLock {
    volatile boolean  flag0 = false;
    volatile boolean flag1 = false;
    volatile int turn;

}

