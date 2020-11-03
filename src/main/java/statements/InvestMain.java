package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a tőkét a befektetéshez: ");
        int fund = scanner.nextInt();
        System.out.println("Add meg a kamatlábat: ");
        int interestRate = scanner.nextInt();
        System.out.println("Add meg hány napra szeretnéd a számítást: ");
        int days = scanner.nextInt();

        Investment invest = new Investment(fund,interestRate);
        System.out.println("Befektetés összege: " + invest.getFund());
        System.out.println("A kamatláb: " + invest.getInterestRate());
        System.out.println("Tőke: " + invest.getFund());
        System.out.println("A hozam " + 50 + " napra: " + invest.getYield(50));
        System.out.println("A kivett összeg " + days + " nap után: " + invest.close(days));
        days += 10;
        System.out.println("A kivett összeg " + days + " nap után: " + invest.close(days));
    }
}
