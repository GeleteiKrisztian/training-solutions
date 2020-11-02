package classstructureio;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        System.out.println("Kérlek add meg a neved: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Add meg az email címedet: ");
        String email = scanner.nextLine();

        System.out.println("Üdv " + name + "! A regisztrált email címed: " + email);
    }
}
