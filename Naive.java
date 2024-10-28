package src.main.java.dsaSchool;

import java.util.HashSet;

public class Naive {

    public static void main(String[] args) {
        Map map = new Map("/Users/samia/IdeaProjects/School/src/main/java/trains.csv");

        String from = "Göteborg";
        String to = "Umeå";
        Integer max = 900;

        long t0 = System.nanoTime();
        HashSet<City> visitedConnections = new HashSet<>();
        visitedConnections.add(map.lookup(from));
        Integer dist = shortest(map.lookup(from), map.lookup(to), max, visitedConnections);
        long time = (System.nanoTime() - t0) / 1_000;

        System.out.println("shortest: " + dist + " min (" + time + " mikro s)");
    }

    private static Integer shortest(City from, City to, Integer max, HashSet<City> visitedConnections) {
        if (max < 0) {
            return null;
        }
        if (from.equals(to)) {
            return 0;
        }

        Integer shortestTime = null;

        for (int i = 0; i < from.connections.size(); i++) {
            if (from.connections.get(i) != null) {
                Connection conn = from.connections.get(i);

                if (!visitedConnections.contains(conn.getTo())) {
                    visitedConnections.add(conn.getTo());
                    Integer remainingMax = max - conn.getMin();
                    Integer time = shortest(conn.getTo(), to, remainingMax, visitedConnections);

                    if (time != null) {
                        int totalTime = conn.getMin() + time;
                        if (shortestTime == null || totalTime < shortestTime) {
                            shortestTime = totalTime;
                        }
                    }

                    visitedConnections.remove(conn.getTo());
                }
            }
        }
        return shortestTime;
    }
}