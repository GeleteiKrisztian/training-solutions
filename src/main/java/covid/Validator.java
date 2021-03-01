package covid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Validator {

    public String readEmailFromConsole() {
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

    public String nameValidator(String name) {
        String[] split = name.split(" ");
        for (int i = 0; i < split.length; i++) {
            boolean isNameStartsWithLowerCase = Character.isLowerCase(split[i].charAt(0));
            if (isNameStartsWithLowerCase) {
                throw new IllegalArgumentException("Invalid name format: " + name + " Full name format required.");
            }
        }
        if (name == null || name.isBlank() || split.length < 2) {
            throw new IllegalArgumentException("Invalid name " + name);
        }
        return name.trim();
    }

    public int zipValidator(int zip) {
        TbdDAO tbdDAO = new TbdDAO();
        try(Connection connection = tbdDAO.getDs().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  cities WHERE zip = ?");
            preparedStatement.setInt(1, zip);
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
            throw new IllegalArgumentException("Invalid zip code " + zip);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't connect to the database.");
        }
    }

    public byte ageValidator(byte age) {
        if (age > 10 && age < 150) {
            return age;
        }
        throw new IllegalArgumentException("Invalid age " + age);
    }

    public String emailValidator(String email) {
        // Ha nincs kukac az emailben,vagy a kukac előtt kevesebb,mint 3 karakter található vagy utána nincs pont
        // karakter,akkor hibát dob
        if (email.contains("@")) {
            String[] split = email.split("@");
            if (split[0].length() > 3 || split[1].contains(".")) {
                return email;
            }
        }
        throw new IllegalArgumentException("Invalid email address " + email);
    }

    public String tajValidator(String taj) {
        if (taj.length() == 9) {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                //Fordítva kell ellenőrizni a páros,vagy páratlan számokat,a 0 indexelés miatt
                int num = Integer.parseInt(Character.toString(taj.charAt(i)));
                if (i % 2 != 1) {
                    sum +=  num * 7;
                } else {
                    sum += num * 3;
                }
            }
            boolean isValidNinthNum = sum % 10 == Integer.parseInt(Character.toString(taj.charAt(8)));
            if (isValidNinthNum) {
                return taj;
            }
        }
        throw new IllegalArgumentException("Invalid TAJ number " + taj);
    }

    public boolean isContainsDbTaj(String taj) {
        try(PreparedStatement preparedStatement =
                    new TbdDAO().getDs().getConnection().prepareStatement("SELECT * FROM citizens WHERE taj = ?")) {
            preparedStatement.setString(1, taj);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }
}

