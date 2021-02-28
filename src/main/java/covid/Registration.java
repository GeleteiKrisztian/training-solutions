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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Teljes név: ");
        String name = scanner.nextLine();
        System.out.print("Irányítószám: ");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.print("Kor: ");
        byte age = Byte.parseByte(scanner.nextLine());
        String email = readEmailFromConsole();
        System.out.print("TAJ szám: ");
        String taj = scanner.nextLine();
        Citizen citizen = new Citizen(name, zip, age, email, taj);
        regCitizen(citizen);
    }

    public void regFromFile() {
        System.out.print("Add meg a file nevét a beolvasáshoz: ");
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
                    String zip = split[1];
                    int age = Integer.parseInt(split[2]);
                    String email = split[3];
                    String taj = split[4];
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, zip);
                    preparedStatement.setInt(3, age);
                    preparedStatement.setString(4, email);
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
            throw new IllegalStateException("DB error.");
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

    private String readEmailFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Email újra: ");
        String emailAgain = scanner.nextLine();
        if (email.equals(emailAgain)) {
            return email;
        }
        throw new IllegalStateException("Email address doesn't match.");
    }
}
