package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator validator = new UserValidator();
        System.out.println("Add meg a felhasználó neved: ");
        String username = scanner.nextLine();
        boolean usernameIsValid = validator.isValidUsername(username);
        System.out.println("A felhasználó név: " + (usernameIsValid ? "helyes" : "helytelen"));

        System.out.println("Add meg az email címed: ");
        String email = scanner.nextLine();
        boolean emailIsValid = validator.isValidEmail(email);
        System.out.println("Az email cím: " + (emailIsValid ? "helyes" : "helytelen"));

        System.out.println("Add meg a jelszavadat: ");
        String firstPass = scanner.nextLine();

        System.out.println("Add meg a jelszavadat újra: ");
        String secondPass = scanner.nextLine();
        boolean passIsValid = validator.isValidPassword(firstPass,secondPass);

        System.out.println("A megadott jelszavak: " + (passIsValid ? "megfelelnek" : "nem felelnek meg" + " a követelményeknek."));
    }
}
