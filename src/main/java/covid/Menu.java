package covid;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<String> menuItems = List.of("Regisztráció", "Tömeges regisztráció", "Generálás", "Oltás", "Oltás elutasítás", "Riport");

    public static void main(String[] args) {
        new Menu().startMenu();
    }

    private void menuChooser(int menuItem) {

        switch (menuItem) {
            case 1:
                new Registration().citizenRegister();
                break;
            case 2:
                new Registration().startRegFromFile();
                break;
            case 3:
                new Generation().startGenerateFirst16CitizenToVaccinateFile();
                break;
            case 4:
                new Vaccination().startVaccinateCitizen();
                break;
            case 5:
                new Vaccination().startExcludeCitizenFromVaccList();
                break;
            case 6:
                new Generation().riport();
        }
    }

    private void startMenu() {
        int selectedMenuItemNumber = -1;
        try {
            while (selectedMenuItemNumber != 0) {
                Menu menu = new Menu();
                // Menüt generál a listában tárolt menü nevekből
                for (int i = 0; i < menu.menuItems.size(); i++) {
                    System.out.println(i + 1 + ". " + menu.menuItems.get(i));
                }
                System.out.println(0 + ". Kilépés");
                System.out.print("\nVálassz menüpontot: ");

                selectedMenuItemNumber = readSelectedMenuItem();

                if (selectedMenuItemNumber == 0) {
                    System.out.println("Köszönjük!");
                    break;
                }
                System.out.println("\n" + menu.menuItems.get(selectedMenuItemNumber - 1));
                menu.menuChooser(selectedMenuItemNumber);
            }
            //NumberFormatException | NullPointerException |
        } catch ( IllegalMenuItemException e) {
            System.out.println("Hibás adatbevitel. Kérlek válassz újra: \n");
            startMenu();
        }
    }

    public int readSelectedMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int selectedMenuItemNumber = Integer.parseInt(scanner.nextLine());
        if (selectedMenuItemNumber < 0 || selectedMenuItemNumber > menuItems.size()) {
            throw new IllegalMenuItemException("Hibás szám.");
        } else {
            return selectedMenuItemNumber;
        }
    }

}
