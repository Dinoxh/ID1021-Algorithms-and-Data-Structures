package src.main.java.dsaSchool;

public class Connection {
    private City fromC;
    private City toC;
    private int minC;

    public Connection (City fromC, City toC, int minC) {
        this.fromC = fromC;
        this.toC = toC;
        this.minC = minC;
    }

    public City getFrom(){
        return fromC;
    }

    public City getTo(){
        return toC;
    }

    public int getMin(){
        return minC;
    }
}
