package src.main.java.dsaSchool;

import java.io.BufferedReader;
import java.io.FileReader;


public class Zipv2 {
    Area[] data;
    int[] keys; // Array to hold zip codes
    int max;
    int capacity;

    public Zipv2(String file, int capacity) {
        this.capacity = capacity;
        this.data = new Area[this.capacity];
        this.keys = new int[this.capacity]; // Initialize the keys array
        this.max = 0; // Keep track of the number of actual elements
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null && max < this.capacity) {
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

    // Insert a new element using linear probing
    public void addEntry(Area area) {
        int hashIndex = area.getZip() % this.capacity;
        int originalIndex = hashIndex;
        int probes = 0;

        // Linear probing to find the correct slot
        while (data[hashIndex] != null) {
            hashIndex = (hashIndex + 1) % this.capacity;
            probes++;
            if (hashIndex == originalIndex) {
                System.out.println("HashTable is full!");
                return;
            }
        }

        // Insert the element
        data[hashIndex] = area;
        keys[max++] = area.getZip(); // Store the zip code for tracking
        System.out.println("Inserted zip code " + area.getZip() + " after " + probes + " probes.");
    }

    private static Integer hash(String name, int mod) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 + name.charAt(i)) % mod;
        }
        return hash;
    }


    // Lookup using linear probing
    public Integer lookup(String targetZip) {
        Integer zipCode = Integer.valueOf(targetZip.replaceAll("\\s", ""));
        int hashIndex = zipCode % this.capacity;
        int originalIndex = hashIndex;
        int probes = 0;

        while (data[hashIndex] != null) {
            if (data[hashIndex].getZip().equals(zipCode)) {
                System.out.println("Found zip code after " + probes + " probes.");
                return data[hashIndex].getZip();
            }
            hashIndex = (hashIndex + 1) % this.capacity;
            probes++;
            if (hashIndex == originalIndex) break;
        }

        System.out.println("Zip code not found after " + probes + " probes.");
        return null;
    }

    // Generate statistics on the number of probes for lookups
    public void statistics() {
        int totalProbes = 0;
        for (int i = 0; i < max; i++) {
            Integer zipCode = keys[i];
            int hashIndex = zipCode % this.capacity;
            int originalIndex = hashIndex;
            int probes = 0;

            while (data[hashIndex] != null) {
                if (data[hashIndex].getZip().equals(zipCode)) {
                    break;
                }
                hashIndex = (hashIndex + 1) % this.capacity;
                probes++;
                if (hashIndex == originalIndex) break;
            }

            totalProbes += probes;
        }
        double averageProbes = (double) totalProbes / max;
        System.out.println("Average probes per lookup: " + averageProbes);
    }

    public int binarySearch(Integer targetZip) {
        int min = 11115;
        int max = 99999; // Change this to the maximum zip code that is valid

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (data[mid] != null && data[mid].getZip().equals(targetZip)) {
                return mid; // Return the index of the found zip code
            } else if (data[mid] != null && data[mid].getZip() < targetZip) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1; // Return -1 if not found
    }

    public void linearSearch(Integer targetZip) {
        boolean found = false; // Flag to indicate if the zip code was found
        for (int i = 11115; i < max; i++) {
            if (data[i] != null && targetZip.equals(data[i].getZip())) {
                System.out.println("The zipcode has been found: " + data[i].getName());
                found = true;
                break; // Exit the loop as we found the zip code
            }
        }
        if (!found) {
            System.out.println("The zipcode was not found!");
        }
    }
}