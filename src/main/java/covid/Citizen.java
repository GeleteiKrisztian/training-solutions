package covid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Citizen {

    private String fullName;
    private int postCode;
    private byte age;
    private String email;
    private String tajId;

    public Citizen(String fullName, int postCode, byte age, String email, String tajId) {
        this.fullName = nameValidator(fullName);
        this.postCode = zipValidator(postCode);
        this.age = ageValidator(age);
        this.email = emailValidator(email);
        this.tajId = tajValidator(tajId);
    }

    public String getFullName() {
        return fullName;
    }

    public int getPostCode() {
        return postCode;
    }

    public byte getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTajId() {
        return tajId;
    }

    private String nameValidator(String name) {
        String[] split = name.split(" ");
        boolean isLastNameStartsWithLowerCase = Character.isLowerCase(split[0].charAt(0));
        boolean isFirstNameStartsWithLowerCase = Character.isLowerCase(split[1].charAt(0));

        if (name == null || name.isBlank() || split.length < 2 || isLastNameStartsWithLowerCase || isFirstNameStartsWithLowerCase ) {
            throw new IllegalArgumentException("Invalid name!");
        }
        return name.trim();
    }

    private int zipValidator(int zip) {
        TbdDAO tbdDAO = new TbdDAO();
        try(Connection connection = tbdDAO.getDs().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  zip_and_cities WHERE zip = ?");
            preparedStatement.setInt(1, zip);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                String fullCityName = res.getString("city");
                String cityPart = res.getString("city_part");
                if (cityPart != null) {
                    fullCityName = fullName + " " + cityPart;
                }
                System.out.println(fullCityName);
                return zip;
            }
            throw new IllegalArgumentException("Invalid zip code.");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't connect to the database.");
        }
    }

    private byte ageValidator(byte age) {
        if (age > 10 && age < 150) {
            return age;
        }
        throw new IllegalArgumentException("Invalid age.");
    }

    private String emailValidator(String email) {
        // Ha nincs kukac az emailben,vagy a kukac előtt kevesebb,mint 3 karakter található vagy utána nincs pont
        // karakter,akkor hibát dob
        if (email.contains("@")) {
            String[] split = email.split("@");
            if (split[0].length() > 3 || split[1].contains(".")) {
                return email;
            }
        }
        throw new IllegalArgumentException("Invalid email adress.");
    }

    private String tajValidator(String taj) {
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
        throw new IllegalArgumentException("Invalid TAJ number.");
    }
}
