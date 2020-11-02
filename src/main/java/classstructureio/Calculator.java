package classstructureio;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Adj meg két egész számot: ");
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        System.out.println(firstNum + "+" + secondNum + "!");
        System.out.println(firstNum + secondNum);

    }
}
