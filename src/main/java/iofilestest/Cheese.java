package iofilestest;

public class Cheese {

    private final String name;
    private final double lactoseAmount;

    public Cheese(String name, double lactoseAmount) {
        this.name = name;
        this.lactoseAmount = lactoseAmount;
    }

    public String getName() {
        return name;
    }

    public double getLactoseAmount() {
        return lactoseAmount;
    }

}
