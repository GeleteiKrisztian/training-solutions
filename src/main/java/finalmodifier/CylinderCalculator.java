package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r,double h) {
        return new CircleCalculator().calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r,double h) {
        return new CircleCalculator().calculatePerimeter(r) * h + 2 * CircleCalculator.PI * (r*r);
    }
}
