package unnamed;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {
        System.out.println("Számítsd ki az alábbi kifejezést és írd be konzolba a végeredményt: 4 + (5 * 3) - (6 / 5) =");
        Scanner scanner = new Scanner(System.in);
        double result = scanner.nextDouble();
        double taskResult = 4 + (5 * 3) - (6 / 5d);
        if(Math.abs(taskResult - result) < 0.0001) {
            System.out.println("Az válasz helyes!");
        } else {
            System.out.println("A válasz helytelen.");
        }
    }

}
