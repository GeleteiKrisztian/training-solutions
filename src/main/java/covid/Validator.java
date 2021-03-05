package covid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validator {

    public static String nameValidator(String name) {
        validateIsNotNullOrEmptyString(name);
        String[] split = name.split(" ");
        if (split.length < 2) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        for (int i = 0; i < split.length; i++) {
            boolean isNameStartsWithLowerCase = Character.isLowerCase(split[i].charAt(0));
            if (isNameStartsWithLowerCase) {
                throw new IllegalArgumentException("Invalid name format: " + name + " Full name format required.");
            }
        }
        return name.trim();
    }

    public static String zipValidator(String zip) {
        validateIsNotNullOrEmptyString(zip);
        MenuDAO menuDAO = new MenuDAO();
        try(Connection connection = menuDAO.getDs().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  cities WHERE zip = ?");
            preparedStatement.setString(1, zip);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                return zip;
            }
            throw new IllegalArgumentException("Invalid zip code: " + zip);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DB error.", sqlException);
        }
    }

    public static byte ageValidator(byte age) {
        if (age > 10 && age < 150) {
            return age;
        }
        throw new IllegalArgumentException("Invalid age: " + age);
    }

    public static String emailsEqual(String email,String emailAgain) {
        validateIsNotNullOrEmptyString(email);
        validateIsNotNullOrEmptyString(emailAgain);
        if (email.equals(emailAgain)) {
            return email;
        }
        throw new IllegalArgumentException("Email address doesn't match.");
    }

    public static String emailValidator(String email) {
        validateIsNotNullOrEmptyString(email);
        // Ha nincs kukac az emailben,vagy a kukac előtt kevesebb,mint 3 karakter található vagy utána nincs pont
        // karakter,akkor hibát dob
        if (email.contains("@")) {
            String[] split = email.split("@");
            if (split[0].length() > 2 && split[1].contains(".")) {
                return email.toLowerCase();
            }
        }
            throw new IllegalArgumentException("Invalid email address: " + email);
    }

    public static String tajValidator(String taj) {
        validateIsNotNullOrEmptyString(taj);
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
        throw new IllegalArgumentException("Invalid TAJ number: " + taj);
    }

    public static boolean isContainsDbTaj(String taj) {
        validateIsNotNullOrEmptyString(taj);
        try(PreparedStatement preparedStatement =
                    new MenuDAO().getDs().getConnection().prepareStatement("SELECT * FROM citizens WHERE taj = ?")) {
            preparedStatement.setString(1, taj);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("TAJ not registered.", sqlException);
        }
    }

    public static void validateIsNotNullOrEmptyString(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("String is null or empty.");
        }
    }
}

