package src.main.java.com.sergdalm.javacore.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Foo {
    private volatile boolean firstCompleted = false;
    private volatile boolean secondCompleted = false;

    public void first(Runnable r) {
        System.out.print("first");
        firstCompleted = true;
    }

    public void second(Runnable r) {
        while(!firstCompleted) {
            // waiting
        }
        System.out.print("second");
        secondCompleted = true;

    }

    public void third(Runnable r) {
        while(!secondCompleted) {
            // waiting
        }
        System.out.print("third");
    }
}

public class FooDemo {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.submit(new B(foo));
        threadPool.submit(new C(foo));
        threadPool.submit(new A(foo));

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);
    }
}

class A implements Runnable {
    Foo foo;

    A(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        foo.first(() -> System.out.print(""));
    }
}

class B implements Runnable {
    Foo foo;

    B(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        foo.second(() -> System.out.print(""));
    }
}

class C implements Runnable {
    Foo foo;

    C(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        foo.third(() -> System.out.print(""));
    }
}