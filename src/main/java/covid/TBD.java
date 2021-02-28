package covid;

import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TBD {

    private List<String> menuItems = List.of("Regisztráció", "Tömeges regisztráció", "Generálás", "Oltás", "Oltás meghiúsulás");

    public static void main(String[] args) {
        new TBD().startMenu();
    }

    private void menuChooser(int menuItem) {
        Registration reg = new Registration();
        switch (menuItem) {
            case 1:
                reg.citizenRegister();
                break;
            case 2:
                reg.regFromFile();
                break;
            case 3:
                System.out.println(new Generation().readFirst16CitizenByZip().size());
        }
    }

    private void startMenu() {
        int item = -1;
        while (item != 0) {
            TBD tbd = new TBD();
            for (int i = 0; i < tbd.menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + tbd.menuItems.get(i));
            }
            System.out.println(0 + ". Kilépés");
            System.out.print("\nVálassz menüpontot: ");
            Scanner scanner = new Scanner(System.in);
            item = Integer.parseInt(scanner.nextLine());
            if (item == 0) {
                System.out.println("Köszönjük!");
                break;
            }
            System.out.println("\n" + tbd.menuItems.get(item - 1));
            tbd.menuChooser(item);
        }
    }
}
