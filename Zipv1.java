package src.main.java.dsaSchool;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zipv1 {
    private Area[][] data; // Array of buckets, each bucket is an array of Area objects
    private int capacity;  // The overall capacity of the hash table
    private int max = 0;   // The total number of elements added

    public Zipv1(String file, int capacity) {
        this.capacity = capacity;
        this.data = new Area[this.capacity][]; // Array of buckets, each bucket initially null

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(","); // CSV
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));

                // Only store valid zip codes
                if (code >= 11115 && code < 100000) {
                    addEntry(new Area(code, row[1], Integer.valueOf(row[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    // Insert a new element into the hash table
    public void addEntry(Area area) {
        int hashIndex = area.getZip() % this.capacity;

        // If no bucket exists at this index, allocate a bucket of size 1
        if (data[hashIndex] == null) {
            data[hashIndex] = new Area[1]; // Initial bucket size is 1
            data[hashIndex][0] = area; // Insert the new element
        } else {
            // Collision: we need to add the element to an existing bucket
            Area[] bucket = data[hashIndex];
            boolean inserted = false;

            // Try to find an empty slot in the existing bucket
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == null) {
                    bucket[i] = area; // Insert the new element
                    inserted = true;
                    break;
                }
            }

            // If no space, allocate a larger bucket
            if (!inserted) {
                Area[] newBucket = new Area[bucket.length + 1]; // Grow the bucket by 1
                System.arraycopy(bucket, 0, newBucket, 0, bucket.length); // Copy old elements
                newBucket[bucket.length] = area; // Add the new element
                data[hashIndex] = newBucket; // Replace the old bucket with the new one
            }
        }
        max++;
        System.out.println("Inserted zip code " + area.getZip());
    }

    // Lookup an element by its zip code
    public Integer lookup(String targetZip) {
        Integer zipCode = Integer.valueOf(targetZip.replaceAll("\\s", ""));
        int hashIndex = zipCode % this.capacity;

        // If a bucket exists at this index, search through it
        if (data[hashIndex] != null) {
            for (Area area : data[hashIndex]) {
                if (area != null && area.getZip().equals(zipCode)) {
                    return area.getZip(); // Return the found zip code
                }
            }
        }

        return null; // Zip code not found
    }

    // Print the contents of the hash table (for debugging)
    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                System.out.print("Index " + i + ": ");
                for (Area area : data[i]) {
                    if (area != null) {
                        System.out.print(area.getZip() + " ");
                    }
                }
                System.out.println();
            }
        }
    }
    public double averageKeysPerIndex() {
        int totalEntries = 0; // To count the total number of entries in the hash table

        // Iterate through each index in the hash table
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                // Count the number of non-null entries in the bucket
                for (Area area : data[i]) {
                    if (area != null) {
                        totalEntries++;
                    }
                }
            }
        }

        // Calculate and return the average
        return (double) totalEntries / capacity;
    }
}