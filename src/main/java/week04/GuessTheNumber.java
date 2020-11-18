package week04;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(99) + 1;
        int counter = 0;
        System.out.println("Adj meg egy számot: ");

        do {
            int inp = scanner.nextInt();
            if (inp < numberToGuess) {
                System.out.println("A kitalálandó szám nagyobb. Kérlek tippelj újra!");
                ++counter;
            } else if (inp > numberToGuess) {
                System.out.println("A kitalálandó szám kisebb. Kérlek tippelj újra!");
                ++counter;
            } else {
                System.out.println("Gratulálok! Kitaláltad. Próbálkozások száma: " + (counter + 1));
                return;
            }
        } while (counter < 6);

        System.out.println("Sajnálom! A kitalálandó szám: " + numberToGuess + " volt.");
    }
}
