package week16d05;

public class CountryManagerHelper implements Comparable<CountryManagerHelper> {

    public String country;
    public Integer allCases;
    public double rate;
    public int index;

    public CountryManagerHelper(String country, Integer allCases, double rate, int index) {
        this.country = country;
        this.allCases = allCases;
        this.rate = rate;
        this.index = index;
    }

    public String getCountry() {
        return country;
    }

    public int getAllCases() {
        return allCases;
    }

    public double getRate() {
        return rate;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(CountryManagerHelper o) {
        double thisResult = allCases / rate;
        double paramResult = o.allCases / o.rate;
        return Double.compare(thisResult, paramResult);
    }
}
