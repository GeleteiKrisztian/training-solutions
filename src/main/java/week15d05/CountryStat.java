package week15d05;

public class CountryStat {

    private long cases;
    private long population;

    public CountryStat(long cases, long population) {
        this.cases = cases;
        this.population = population;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getCases() {
        return cases;
    }

    public long getPopulation() {
        return population;
    }
}
