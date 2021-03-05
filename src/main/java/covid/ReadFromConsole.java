package covid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadFromConsole {

    private Scanner scanner = new Scanner(System.in);

    public String readFileName() {
        System.out.print("Add meg a file nevét a beolvasáshoz (kiterjesztéssel): ");
        String fileName = scanner.nextLine();
        return fileName;
    }

    public String readEmailFromConsole() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Email újra: ");
        String emailAgain = scanner.nextLine();
        String validEmail = Validator.emailsEqual(email, emailAgain);
        return Validator.emailValidator(validEmail);
    }

    public String readZip() {
        System.out.println("Irányítószám: ");
        String zip = Validator.zipValidator(scanner.nextLine());
        MenuDAO menuDAO = new MenuDAO();
        try(Connection connection = menuDAO.getDs().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  cities WHERE zip = ?");
            preparedStatement.setString(1, zip);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                String fullCityName = res.getString("city");
                String cityPart = res.getString("city_part");
                if (cityPart != null) {
                    fullCityName += " (" + cityPart + ")";
                }
                System.out.println(fullCityName);
                return zip;
            }
            throw new IllegalArgumentException("Invalid zip code: " + zip);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DB error.", sqlException);
        }
    }

    public String readDescription() {
        System.out.println("Megjegyzés: ");
        String desc = scanner.nextLine();
        return desc;
    }

    public Citizen readCitizen() {
        System.out.print("Teljes név: ");
        String name = Validator.nameValidator(scanner.nextLine());
        String zip = Validator.zipValidator(readZip());
        System.out.print("Életkor: ");
        byte age = Validator.ageValidator(Byte.parseByte(scanner.nextLine()));
        String emailToVal = readEmailFromConsole();
        String email = Validator.emailValidator(emailToVal);
        System.out.print("TAJ szám: ");
        String taj = Validator.tajValidator(scanner.nextLine());
        Citizen citizen = new Citizen(name, zip, age, email, taj);
        return citizen;
    }

    public String readTaj() {
        System.out.println("TAJ szám: ");
        String taj = scanner.nextLine();
        return Validator.tajValidator(taj);
    }
}
