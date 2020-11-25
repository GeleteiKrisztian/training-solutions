package methodstructure;

public class BodyMass {

    private double weight;
    private double height;
    private final double underLimit = 18.5;
    private final double overLimit = 25;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight / (height * height);
    }

    public BmiCategory body() {
        if (bodyMassIndex() < underLimit) {
            return BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex() > overLimit) {
            return BmiCategory.OVERWEIGHT;
        } else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        if (bodyMassIndex() < bodyMass.bodyMassIndex()) {
            return true;
        }
        return false;
    }

}
