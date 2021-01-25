package week13d01;

public class City {

    private int zipCode;
    private String name;
    private String cityPart;

    public City(int zipCode, String name, String cityPart) {
        this.zipCode = zipCode;
        this.name = name;
        this.cityPart = cityPart;
    }

    public City(int zipCode, String name) {
        this.zipCode = zipCode;
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getCityPart() {
        return cityPart;
    }
}
