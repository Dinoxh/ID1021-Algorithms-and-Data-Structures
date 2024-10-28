package src.main.java.dsaSchool;

public class HashTableComparison {
    public static void main(String[] args) {
        String filePath = "/Users/samia/Downloads/postnummer.csv";  // Your data file with zip codes
        int[] capacities = {10000, 20000, 50000, 100000};  // Different array sizes for testing
        int numTests = 5;  // Number of zip codes to test

        // Perform the tests for both versions
        for (int capacity : capacities) {
            System.out.println("Testing with capacity: " + capacity);

            // Testing Zipv1 (bucket-based approach)
            System.out.println("\n--- Testing Zipv1 (bucket-based) ---");
            Zipv1 zipv1 = new Zipv1(filePath, capacity);
            runTest(zipv1, numTests);

            // Testing Zipv2 (linear probing)
            System.out.println("\n--- Testing Zipv2 (linear probing) ---");
            Zipv2 zipv2 = new Zipv2(filePath, capacity);
            runTest(zipv2, numTests);
        }
    }

    public static void runTest(Object zip, int numTests) {
        // Generate random zip codes for testing
        int[] testZipCodes = generateRandomZipCodes(numTests);

        // Measure insertion performance
        long startInsertTime = System.nanoTime();
        for (int zipCode : testZipCodes) {
            if (zip instanceof Zipv1) {
                ((Zipv1) zip).addEntry(new Area(zipCode, "Test Area", 1000));
            } else if (zip instanceof Zipv2) {
                ((Zipv2) zip).addEntry(new Area(zipCode, "Test Area", 1000));
            }
        }
        long endInsertTime = System.nanoTime();
        System.out.println("Insertion Time: " + (endInsertTime - startInsertTime) + " ns");

        // Measure lookup performance
        long startLookupTime = System.nanoTime();
        for (int zipCode : testZipCodes) {
            if (zip instanceof Zipv1) {
                ((Zipv1) zip).lookup(String.valueOf(zipCode));
            } else if (zip instanceof Zipv2) {
                ((Zipv2) zip).lookup(String.valueOf(zipCode));
            }
        }
        long endLookupTime = System.nanoTime();
        System.out.println("Lookup Time: " + (endLookupTime - startLookupTime) + " ns");

        // Optionally print the table for debugging (commented out to avoid large output)
        // if (zip instanceof Zipv1) ((Zipv1) zip).printTable();
        // if (zip instanceof Zipv2) ((Zipv2) zip).printTable();
    }

    public static int[] generateRandomZipCodes(int num) {
        int[] zipCodes = new int[num];
        for (int i = 0; i < num; i++) {
            zipCodes[i] = 11115 + (int) (Math.random() * (100000 - 11115)); // Generate random valid zip codes
        }
        return zipCodes;
    }
}
