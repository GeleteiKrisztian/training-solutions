package finalmodifier;

public class PiMain {

    public static void main(String[] args) {
        double r = 5;
        CircleCalculator circleCalculator = new CircleCalculator();
        System.out.println(circleCalculator.calculatePerimeter(r));
        System.out.println(circleCalculator.calculateArea(r));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println(cylinderCalculator.calculateVolume(r,12.0));
        System.out.println(cylinderCalculator.calculateSurfaceArea(r,9.0));
        System.out.println(CircleCalculator.PI);
    }
}
