package covid;

import java.util.Scanner;

public class ReadFromConsole {

    private Scanner scanner = new Scanner(System.in);

    public static String readEmailFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Email újra: ");
        String emailAgain = scanner.nextLine();
        String validEmail = Validator.emailsEqual(email, emailAgain);
        return Validator.emailValidator(validEmail);
    }

    public String readZip() {
        System.out.println("Add meg az irányítószámot a szűréshez: ");
        String zip = Validator.zipValidator(scanner.nextLine());
        return zip;
    }

    public String readDescription() {
        System.out.println("Megjegyzés: ");
        String desc = scanner.nextLine();
        return desc;
    }

    public Citizen readCitizen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teljes név: ");
        String name = Validator.nameValidator(scanner.nextLine());
        System.out.print("Irányítószám: ");
        String zip = Validator.zipValidator(scanner.nextLine());
        System.out.print("Életkor: ");
        byte age = Validator.ageValidator(Byte.parseByte(scanner.nextLine()));
        String emailToVal = ReadFromConsole.readEmailFromConsole();
        String email = Validator.emailValidator(emailToVal);
        System.out.print("TAJ szám: ");
        String taj = Validator.tajValidator(scanner.nextLine());
        Citizen citizen = new Citizen(name, zip, age, email, taj);
        return citizen;
    }

    public String readTaj() {
        System.out.println("TAJ szám: ");
        Scanner scanner = new Scanner(System.in);
        String taj = scanner.nextLine();
        return Validator.tajValidator(taj);
    }
}
