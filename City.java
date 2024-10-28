package src.main.java.dsaSchool;

import java.util.ArrayList;

public class City {
    public ArrayList<Connection> connections;
    String City;

    public City(String City){
        this.City = City;
        this.connections = new ArrayList<>();
    }

    public void connect(City toC, int minC){
        connections.add(new Connection(this, toC, minC));
    }

    public String getCity(){
        return City;
    }

}
