package src.main.java.dsaSchool;

public class Paths {
    static City[] path; // Array to hold the current path of cities
    static int sp; // Stack pointer to track the number of cities in the path
    static Integer maxDistance; // Dynamic maximum distance (null initially)

    public static void main(String[] args) {
        Map map = new Map("/Users/samia/IdeaProjects/School/src/main/java/trains.csv");

        String from = "Göteborg";
        String to = "Umeå";

        path = new City[54]; // Assuming a maximum of 54 cities, adjust as necessary
        sp = 0; // Start the path index at 0
        maxDistance = null; // Initially, there is no maximum distance restriction

        long  t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), 0);
        long time = (System.nanoTime() - t0)/1_000;

        System.out.println("shortest: " + dist + " min (" + time + " mikro s)");
    }

    // Constructor to initialize the path array and other variables
    public Paths() {
        path = new City[54]; // Assuming a maximum of 54 cities, adjust as necessary
        sp = 0; // Start the path index at 0
        maxDistance = null; // Initially, there is no maximum distance restriction
    }

    // Function to find the shortest path between two cities
    private static Integer shortest(City from, City to, int accumulatedDistance) {
        // If we have reached the destination, return the accumulated distance
        if (from.equals(to)) {
            return accumulatedDistance;
        }

        // Check if the current city is already in the path (to avoid loops)
        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null; // If found, abort this path to prevent loops
            }
        }

        // Add the current city to the path
        path[sp++] = from;

        Integer shortestDistance = null;

        // Iterate over all connected cities (neighbors)
        for (Connection connection : from.connections) {
            City nextCity = connection.getTo();
            int distanceToNext = accumulatedDistance + connection.getMin();

            // Check if the accumulated distance already exceeds the current maxDistance
            if (maxDistance != null && distanceToNext >= maxDistance) {
                continue; // Skip this path as it will not yield a shorter route
            }

            // Recursively try to find the shortest path from the next city
            Integer result = shortest(nextCity, to, distanceToNext);
            if (result != null) {
                // Update the shortest distance found
                if (shortestDistance == null || result < shortestDistance) {
                    shortestDistance = result;
                    // Update maxDistance to the new shortest path length found
                    maxDistance = shortestDistance;

                }
            }
        }

        // Backtrack: Remove the current city from the path before returning
        path[--sp] = null;
        return shortestDistance;
    }

    // Public method to find the shortest path from one city to another
    public Integer findShortestPath(City from, City to) {
        // Reset maxDistance and start the search
        maxDistance = null;
        return shortest(from, to, 0);
    }
}