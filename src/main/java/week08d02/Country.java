package week08d02;

public class Country {

    private String countryName;
    private long population;
    private int numberOfFlagColor;
    private int neighboringCountries;

    public Country(String countryName, long population, int numberOfFlagColor, int neighboringCountries) {
        this.countryName = countryName;
        this.population = population;
        this.numberOfFlagColor = numberOfFlagColor;
        this.neighboringCountries = neighboringCountries;
    }

    public String getCountryName() {
        return countryName;
    }

    public long getPopulation() {
        return population;
    }

    public int getNumberOfFlagColor() {
        return numberOfFlagColor;
    }

    public int getNeighboringCountries() {
        return neighboringCountries;
    }
}
