package covid;

import java.util.List;
import java.util.Scanner;

public class TBD {

    private List<String> menuItems = List.of("Regisztráció", "Tömeges regisztráció", "Generálás", "Oltás", "Oltás elutasítás", "Riport");

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
                new Generation().generateFirst16CitizenToVaccinateFile();
                break;
            case 4:
                new Vaccination().vaccinateCitizen();
                break;
            case 5:
                new Vaccination().excludeCitizenFromVaccination();
                break;
        }
    }

    private void startMenu() {
        int selectedMenuItemNumber = -1;
        try {
            while (selectedMenuItemNumber != 0) {
                TBD tbd = new TBD();
                // Menüt generál a listában tárolt menü nevekből
                for (int i = 0; i < tbd.menuItems.size(); i++) {
                    System.out.println(i + 1 + ". " + tbd.menuItems.get(i));
                }
                System.out.println(0 + ". Kilépés");
                System.out.print("\nVálassz menüpontot: ");

                selectedMenuItemNumber = readSelectedMenuItem();

                if (selectedMenuItemNumber == 0) {
                    System.out.println("Köszönjük!");
                    break;
                }
                System.out.println("\n" + tbd.menuItems.get(selectedMenuItemNumber - 1));
                tbd.menuChooser(selectedMenuItemNumber);
            }
        } catch (NumberFormatException | NullPointerException | IllegalMenuItemException e) {
            System.out.println("Hibás adatbevitel. Kérlek válassz újra: \n");
            startMenu();
        }
    }

    private int readSelectedMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int selectedMenuItemNumber = Integer.parseInt(scanner.nextLine());
        if (selectedMenuItemNumber < 0 || selectedMenuItemNumber > menuItems.size()) {
            throw new IllegalMenuItemException("Hibás szám.");
        } else {
            return selectedMenuItemNumber;
        }
    }
}
