package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adj meg egy számot:");
        int num = scanner.nextInt();
        System.out.println(num > 100 ? "Nagyobb,mint 100" : "Száz,vagy kisebb");
    }
}
