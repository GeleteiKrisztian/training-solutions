package covid;

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
                new Generation().generateFile();
                break;
            case 4:
                new Vaccination().VaccinationCitizen();
                break;
        }
    }

    private void startMenu() {
        int item = -1;
        try {
            while (item != 0) {
                TBD tbd = new TBD();
                for (int i = 0; i < tbd.menuItems.size(); i++) {
                    System.out.println(i + 1 + ". " + tbd.menuItems.get(i));
                }
                System.out.println(0 + ". Kilépés");
                System.out.print("\nVálassz menüpontot: ");
                Scanner scanner = new Scanner(System.in);
                item = Integer.parseInt(scanner.nextLine());
                if (item < 0 || item > menuItems.size()) {
                    throw new IllegalMenuItemException("Hibás szám.");
                }
                if (item == 0) {
                    System.out.println("Köszönjük!");
                    break;
                }
                System.out.println("\n" + tbd.menuItems.get(item - 1));
                tbd.menuChooser(item);
            }
        } catch (NumberFormatException | NullPointerException | IllegalMenuItemException e) {
            System.out.println("Hibás adatbevitel. Kérlek válassz újra: \n" + e.getMessage());
            startMenu();
        }
    }
}
