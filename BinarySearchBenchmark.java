package src.main.java.dsaSchool;

import java.util.Random;

public class BinarySearchBenchmark {
    public static void main(String[] args){

        // Initialize an array of different sizes to benchmark
        int[] sizes = {100, 1000, 10000, 100000, 1000000}; // Test for n = 100, 1000, 10000, 100000, 1000000
        Random random = new Random();

        // Loop over each data size and perform the benchmarking
        for (int n : sizes) {
            int[] array = new int[n];

            // Populate the array with sorted elements
            for(int i = 0 ; i < n ; i++){
                array[i] = i; //creates a sorted array with elements 0 to n-1
            }

            // Perform the binary search benchmark
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                int target = random.nextInt(n); // Search for random elements in the array
                binarySearch(array, target);
            }
            long end = System.nanoTime();
            long time = (end - start) / 1_000;  // Convert to microseconds
            System.out.println("Binary Search Time for n = " + n + ": " + time + " µs");

            // Print a separator for readability
            System.out.println("------------------------------------------------");
        }
    }

    public static int binarySearch(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int value = array[mid];

            if(value < target){
                low = mid + 1;
            }
            else if(value > target){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1; // Target not found
    }
}