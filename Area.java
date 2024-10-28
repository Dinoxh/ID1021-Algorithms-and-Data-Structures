package src.main.java.dsaSchool;

public class Area{
    Integer zip;
    String name;
    Integer population;

    public Area(Integer zip, String name, int population){
        this.zip = zip;
        this.name = name;
        this.population = population;
    }

    public Integer getZip(){
        return zip;
    }

    public String getName(){
        return name;
    }

    public Integer getPopulation(){
        return population;
    }


}