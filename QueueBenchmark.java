package src.main.java.dsaSchool;

import java.util.Random;

public class QueueBenchmark {

    public static void main(String[] args) {
        int maxExponent = 5; // Test for n = 10^1, 10^2, ..., 10^maxExponent

        // Loop over different sizes of n (10^i)
        for (int i = 1; i <= maxExponent; i++) {
            int n = (int) Math.pow(10, i);
            System.out.println("Running benchmark for n = 10^" + i + " (" + n + " elements):");
            runBenchmark(n);
            System.out.println();
        }
    }

    public static void runBenchmark(int dataSize) {
        QueueV2 queue = new QueueV2();
        Random random = new Random();

        // Benchmark enqueue operation

        for (int i = 0; i < dataSize-1; i++) {
            queue.enqueue(random.nextInt());
        }
        long enqueueStartTime = System.nanoTime();
        queue.enqueue(random.nextInt());
        long enqueueEndTime = System.nanoTime();

        long enqueueDuration = enqueueEndTime - enqueueStartTime;
        System.out.println("Time taken to enqueue " + dataSize + " elements: " + (enqueueDuration / 1_000) + "μs");

        long dequeueStartTime = System.nanoTime();
        queue.dequeue();
        long dequeueEndTime = System.nanoTime();
        long dequeueDuration = dequeueEndTime - dequeueStartTime;
        System.out.println("Time taken to dequeue " + dataSize + " elements: " + (dequeueDuration / 1_000) + " μs");
    }
}
