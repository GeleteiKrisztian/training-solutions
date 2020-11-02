package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérlek add meg a kedvenc zeneszámod adatait: ");
        System.out.println("Előadó/Együttes: ");
        song.band = scanner.nextLine();
        System.out.println("Cím: ");
        song.title = scanner.nextLine();
        System.out.println("Hossz: (Perc) ");
        song.length = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A megadott adatok alapján a kedvenc zenéd: ");
        System.out.println(song.band + " - " + song.title + " (" + song.length + " perc)");
    }
}
