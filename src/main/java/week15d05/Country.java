package week15d05;

public class Country {
    private String name;
    private long cases;
    private long population;

    public Country(String name, long cases, long population) {
        this.name = name;
        this.cases = cases;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public long getCases() {
        return cases;
    }

    public long getPopulation() {
        return population;
    }
}
