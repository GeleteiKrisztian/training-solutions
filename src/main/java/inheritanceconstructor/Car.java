package inheritanceconstructor;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (calculateRefillAmount() < fuel) {
            throw new RuntimeException("Tank capacity is less than fuel!");
        }
        this.fuel += fuel;
    }

    public void drive(int km) {
        isEnoughtFuelToDrive(km);
        fuel -= (km * fuelRate) / 100;
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    private void isEnoughtFuelToDrive(int km) {
        double fuelUsed = (km * fuelRate) / 100;
        if ((fuel - fuelUsed) < 0) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

}
