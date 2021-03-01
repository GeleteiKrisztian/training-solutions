package covid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

    public void citizenRegister() {
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teljes név: ");
        String name = validator.nameValidator(scanner.nextLine());
        System.out.print("Irányítószám: ");
        int zip = validator.zipValidator(Integer.parseInt(scanner.nextLine()));
        System.out.print("Életkor: ");
        byte age = validator.ageValidator(Byte.parseByte(scanner.nextLine()));
        String email = validator.emailValidator(validator.readEmailFromConsole());
        System.out.print("TAJ szám: ");
        String taj = validator.tajValidator(scanner.nextLine());
        Citizen citizen = new Citizen(name, zip, age, email, taj);
        regCitizen(citizen);
    }

    public void regFromFile() {
        Validator validator = new Validator();
        System.out.print("Add meg a file nevét a beolvasáshoz (kiterjesztéssel): ");
        String fileName = "/" + new Scanner(System.in).nextLine();
        TbdDAO tbdDAO = new TbdDAO();
        try (Connection connection = tbdDAO.getDs().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?, ?, ?, ?, ?)")) {
            InputStream is = TBD.class.getResourceAsStream(fileName);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                connection.setAutoCommit(false);
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] split = line.split(";");
                    String name = split[0];
                    int zip = Integer.parseInt(split[1]);
                    byte age = Byte.parseByte(split[2]);
                    String email = split[3];
                    String taj = split[4];
                    preparedStatement.setString(1, name); //namevalidator
                    preparedStatement.setString(2, String.valueOf(zip)); //zipvalidator
                    preparedStatement.setInt(3, validator.ageValidator(age));
                    preparedStatement.setString(4, validator.emailValidator(email)); // tajvalidator
                    preparedStatement.setString(5, taj);
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                System.out.println("Sikeres beolvasás és feltöltés.\n");
            } catch (IOException ioe) {
                throw new IllegalArgumentException("Can't read from the file.");
            }
            connection.commit();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Email or TAJ duplicate.");
        }
    }

    private void regCitizen(Citizen citizen) {
        try (PreparedStatement preparedStatement = new TbdDAO().getDs().getConnection().prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, citizen.getFullName());
            preparedStatement.setString(2, String.valueOf(citizen.getPostCode()));
            preparedStatement.setByte(3, citizen.getAge());
            preparedStatement.setString(4, citizen.getEmail());
            preparedStatement.setString(5, citizen.getTajId());
            preparedStatement.executeUpdate();
            System.out.println("Sikeres regisztráció.\n");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't register citizen.");
        }
    }

}
