package src.main.java.com.sergdalm.javacore.сhapter28;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorCompletionService completionService = new ExecutorCompletionService(executorService);

        completionService.submit(() -> {
            return null;
        });

        try {
            Future take = completionService.take();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
