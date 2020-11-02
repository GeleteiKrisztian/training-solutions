package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a neved: ");
        client.name = scanner.nextLine();

        System.out.println("Add meg mikor születtél: ");
        client.year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Add meg melyik város: ");
        client.address = scanner.nextLine();

        System.out.println("Üdv " + client.name + "!");
        System.out.println("Születési év: " + client.year);
        System.out.println("Város: " + client.address);
    }
}
