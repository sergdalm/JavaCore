package src.main.java.com.sergdalm.javacore.сhapter28;

// A simple program that let you experiment with the effects of
// changing the threshold and parallelism of a ForkJoinTask.
import java.text.DecimalFormat;
import java.util.concurrent.*;

// Demonstrates parallel execution.
public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if(args.length != 2) {
            System.out.println("UsageL FJExperiment parallelism threshold");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        // These variables are used to time the task.
        long beginT, endT;

        // Create a task pool. Notice that the parallelism level is set.
        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[100000];

        for(int i = 0; i < nums.length; i++)
            nums[i] = (double) i;

        Transform task = new Transform(nums, 0, nums.length, threshold);

        // Starting timing.
        beginT = System.nanoTime();

        // Start the main ForkJoinTask
        fjp.invoke(task);

        // End timing.
        endT = System.nanoTime();
        System.out.println("Level of parallelism: " + pLevel);
        System.out.println("Sequential threshold: " + threshold);
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println("Elapsed time: " + formatter.format(endT - beginT) + " ns");
        System.out.println();
    }
}



// A ForkJoinTask (via RecursiveAction) that performs a
// transform on the elements of the array of doubles.
class Transform extends RecursiveAction {

    // Sequential threshold, which is set by the constructor.
    int seqThreshold;

    // Array to be accessed.
    double[] data;

    // Determines what part of data to process.
    int start, end;

    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    // This is the method in which parallel computation will occur.
    protected void compute() {

        // If number of elements is below the sequential threshold,
        // then process sequentially.
        if((end - start) < seqThreshold) {
            // The following code assigns an element at an even index the
            // square root of its original value. An element at an odd
            // index if assigned its cube root. This code is designed
            // to simply consume CPU time so that the effects of concurrent
            // execution are more readily observable.
            for(int i = start; i < end; i++) {
                if((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        }
        else {
            // Otherwise, continue to break the data into smaller pieces.

            // Find the midpoint.
            int middle = (start + end) / 2;

            // Invoke new tasks, using the subdivided data.
            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}

