package ioreaderclasspath;

public class Country {

    private String country;
    private int borderCountry;

    public Country(String country, int borderCountry) {
        this.country = country;
        this.borderCountry = borderCountry;
    }

    public String getName() {
        return country;
    }

    public int getBorderCountries() {
        return borderCountry;
    }
}
