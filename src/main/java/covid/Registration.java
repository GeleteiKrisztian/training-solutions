package covid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {

    public void citizenRegister() {
        Citizen citizen = new ReadFromConsole().readCitizen();
        regCitizen(citizen);
    }

    public void startRegFromFile() {
        String file = new ReadFromConsole().readFileName();
        regFromFile(file);
    }

    public void regFromFile(String file) {
        String fileName = "/" + file;
        MenuDAO menuDAO = new MenuDAO();
        try (Connection connection = menuDAO.getDs().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?, ?, ?, ?, ?)")) {
            InputStream is = Menu.class.getResourceAsStream(fileName);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                connection.setAutoCommit(false);
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] split = line.split(";");
                    String name = split[0];
                    String zip = split[1];
                    byte age = Byte.parseByte(split[2]);
                    String email = split[3];
                    String taj = split[4];
                    preparedStatement.setString(1, Validator.nameValidator(name));
                    preparedStatement.setString(2, Validator.zipValidator(zip));
                    preparedStatement.setInt(3, Validator.ageValidator(age));
                    preparedStatement.setString(4, Validator.emailValidator(email)); // tajvalidator
                    preparedStatement.setString(5, Validator.tajValidator(taj));
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                System.out.println("Sikeres beolvasás és feltöltés.\n");
            } catch (IOException ioe) {
                throw new IllegalArgumentException("Can't read from the file.", ioe);
            }
            connection.commit();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Email or TAJ duplicate.");
        }
    }

    public void regCitizen(Citizen citizen) {
        try (PreparedStatement preparedStatement = new MenuDAO().getDs().getConnection().prepareStatement("INSERT INTO citizens (citizen_name, zip, age, email, taj) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, citizen.getFullName());
            preparedStatement.setString(2, citizen.getPostCode());
            preparedStatement.setByte(3, citizen.getAge());
            preparedStatement.setString(4, citizen.getEmail());
            preparedStatement.setString(5, citizen.getTajId());
            preparedStatement.executeUpdate();
            System.out.println("Sikeres regisztráció.\n");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't register citizen. " + sqlException.getMessage(), sqlException);
        }
    }

}
