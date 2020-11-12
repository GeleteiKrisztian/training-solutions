package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg az 1. kör átmérőjét:");
        int firstCircleDiameter = scanner.nextInt();
        System.out.println("Add meg a 2. kör átmérőjét:");
        int SecCircleDiameter = scanner.nextInt();

        Circle circle1 = new Circle(firstCircleDiameter);
        Circle circle2 = new Circle(SecCircleDiameter);

        System.out.println("Az első kör kerülete: " + circle1.perimeter());
        System.out.println("Az első kör területe: " + circle1.area());
        System.out.println("A második kör kerülete: " + circle2.perimeter());
        System.out.println("A második kör területe: " + circle2.area());

    }
}
