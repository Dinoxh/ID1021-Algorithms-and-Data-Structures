package src.main.java.dsaSchool;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

    public City[] cities;
    private final int mod = 55;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City one = lookup(row[0]);
                City two = lookup(row[1]);
                one.connect(two, Integer.parseInt(row[2]));
                two.connect(one, Integer.parseInt(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private static Integer hash(String name, int mod) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i);
        }
        return hash % mod;


    }

    // Lookup using linear probing
    public City lookup(String city) {
        int hashIndex = hash(city, mod);
        int originalIndex = hashIndex;

        while (cities[hashIndex] != null) {
            if (cities[hashIndex].getCity().equals(city)) {
                return cities[hashIndex];
            }
            hashIndex = (hashIndex + 1) % mod;
            if (hashIndex == originalIndex) {
                throw new IllegalStateException("Hash table is full");
            }
        }

        // If city not found, add new city
        City newCity = new City(city);
        cities[hashIndex] = newCity;
        return newCity;
    }

    private void addEntry(int index, City city) {
        cities[index] = city;
    }
}
