package inheritanceconstructor;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (fuel > getTankCapacity() + extraCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
            if (calculateRefillAmount() < fuel) {
                throw new RuntimeException("Tank capacity is less than fuel!");
            }

            if (getFuel() < getTankCapacity()) {
                fuel -= getTankCapacity() - getFuel();
                setFuel(getFuel() + (getTankCapacity() - getFuel()));
                extraFuel += fuel;
            } else {
                extraFuel += fuel;
            }
    }

    @Override
    public void drive(int km) {
        isEnoughtFuelToDrive(km);
        double fuelNeed = (km * getFuelRate()) / 100;
        if (extraFuel <  fuelNeed) {
            double fuelLeft = fuelNeed - extraFuel;
            extraFuel = 0;
            setFuel(getFuel() - fuelLeft);
        } else {
            extraFuel -= fuelNeed;
        }
    }

    @Override
    public double calculateRefillAmount() {
        return (getTankCapacity() + extraCapacity) - (getFuel() + extraFuel);
    }

    private void isEnoughtFuelToDrive(int km) {
        double fuelUsed = (km * getFuelRate()) / 100;
        if ((getFuel() - fuelUsed) < 0) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

}
