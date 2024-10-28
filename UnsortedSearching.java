package src.main.java.dsaSchool;


import static java.lang.Math.random;

//unsorted: random numbers at all indices
//sorted: numbers in order at all indices
public class UnsortedSearching {

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000, 1000000};  // Array sizes for testing

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];  // Correctly assign the current array size
            System.out.println("Array size: " + size);

            int[] array = randomArrayGenerator(size);  // Generate array with the correct size

            // Test best case: key is the first element
            System.out.println("Best Case:");
            benchmark(array, array[0]);  // Search for the first element

            // Test average case: key is a middle element
            System.out.println("Average Case:");
            benchmark(array, array[size / 2]);  // Search for a middle element

            // Test worst case: key is not present
            System.out.println("Worst Case:");
            benchmark(array, -1);  // Search for a non-existent element

            System.out.println();
        }


    }




    public static void benchmark(int[] array, int key){
        long startTime = System.nanoTime();
        boolean result = unsorted_search(array, key);
        long endTime = System.nanoTime();

        System.out.println("Key found: " + result);
        System.out.println("Time taken (nanoseconds): " + (endTime - startTime));
    }

    public static boolean unsorted_search(int[] array, int key) {
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static int[] randomArrayGenerator(int size){ //creates an array of a given size, with unsorted elements
        int[] array = new int[size];
        for(int i = 0 ; i < array.length ; i++){
            array[i] = (int)(random() * size);
        }
        return array;
    }

}
