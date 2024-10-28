package src.main.java.dsaSchool;

import java.util.Random;

public class SortedSearching {

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000, 1000000};  // Array sizes for testing

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];  // Correctly assign the current array size
            System.out.println("Array size: " + size);

            int[] array = sorted(size);  // Generate a sorted array with the correct size

            // Test best case: key is the first element
            System.out.println("Best Case:");
            benchmark(array, array[0]);  // Search for the first element

            // Test average case: key is a random element in the array
            System.out.println("Average Case:");
            int randomIndex = (int) (Math.random() * size);  // Select a random index
            benchmark(array, array[size / 2]);  // Search for a random element

            // Test worst case: key is not present
            System.out.println("Worst Case:");
            benchmark(array, -1);  // Search for a non-existent element

            System.out.println();  // Blank line for readability
        }
    }

    // Benchmark method to measure execution time of optimized_search
    public static void benchmark(int[] array, int key) {
        long startTime = System.nanoTime();
        boolean result = search(array, key);  // Perform the optimized search
        long endTime = System.nanoTime();

        // Output results
        System.out.println("Optimized - Key found: " + result);
        System.out.println("Optimized - Time taken (nanoseconds): " + (endTime - startTime));
    }

    // Optimized search in a sorted array that stops early
    public static boolean search(int[] array, int key) {
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    // Generates a sorted array of given size
    private static int[] sorted(int size) {
        Random rnd = new Random();
        int[] array = new int[size];
        int nxt = 0;
        for (int i = 0; i < size; i++) {
            nxt += rnd.nextInt(10) + 1;  // Ensure each subsequent element is greater
            array[i] = nxt;
        }
        return array;
    }
}
