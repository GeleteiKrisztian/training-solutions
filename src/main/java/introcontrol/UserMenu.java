package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Felhasználók listázása\n2. Felhasználó felvétele\n3. Többi: Kilépés");

        int inp = scanner.nextInt();
        if (inp == 1) {
            System.out.println("Felhasználók listázása");
        }
        if(inp == 2) {
            System.out.println("Felhasználó felvétele");
        }
    }
}
