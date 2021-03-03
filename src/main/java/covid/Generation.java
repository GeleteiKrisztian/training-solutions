package covid;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Generation {

    public List<Citizen> readFirst16CitizenToVaccinate(String zip) {
        List<Citizen> citizens = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    new TbdDAO().getDs().getConnection().prepareStatement("SELECT * FROM citizens LEFT JOIN vaccinations ON citizen_id = vaccinations.citizen_id_f WHERE zip = ? AND (number_of_vaccination = 0 OR (number_of_vaccination > 0 AND number_of_vaccination < 2 AND last_vaccination < ?)) ORDER BY zip, age DESC, citizen_name, number_of_vaccination ASC LIMIT 1")) {
            preparedStatement.setString(1, zip);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now().minusDays(15)));
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString("citizen_name");
                String zipCode = res.getString("zip");
                byte age = res.getByte("age");
                String email = res.getString("email");
                String taj = res.getString("taj");
                byte numOfVaccs = res.getByte("number_of_vaccination");
                Timestamp lastVaccination = Optional.ofNullable(res.getTimestamp("last_vaccination")).orElse(Timestamp.valueOf(LocalDateTime.of(2037,1,1,0,0)));
                LocalDateTime lastVaccDateTime = lastVaccination.toLocalDateTime();
            String vaccTypeStr = res.getString("vaccination_type");
            VaccineType vaccineType = null;
            if (vaccTypeStr != null) {
                vaccineType = VaccineType.valueOf(vaccTypeStr);
            }
                Citizen citizen = new Citizen(id, name, zipCode, age, email, taj, numOfVaccs, lastVaccDateTime, vaccineType);
                citizens.add(citizen);
            }
            return citizens;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't read citizens from the DB");
        }
    }

    public void generateFirst16CitizenToVaccinateFile() {
        String zip = new ReadFromConsole().readZip();
        List<Citizen> citizens = readFirst16CitizenToVaccinate(zip);
        System.out.print("Add meg a fájl nevét (kiterjesztéssel együtt) a mentéshez: ");
        String file = new Scanner(System.in).nextLine();
        if (!file.contains(".")) {
            file += ".txt";
        }
        try(BufferedWriter br = Files.newBufferedWriter(Path.of(file))) {
            LocalTime time = LocalTime.of(8,0);
            //Ez a rész,azért kell,hogy ne legyen a fájl üres,amikor már nincs kit beoltani
            StringBuilder sb = new StringBuilder("Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            br.write(sb.toString());
            sb = new StringBuilder();

            for (Citizen item : citizens) {
                sb.append(time.toString()).append(";").append(item.getFullName()).append(";").append(item.getPostCode()).append(";");
                sb.append(item.getAge()).append(";").append(item.getEmail()).append(";").append(item.getTajId());
                time = time.plusMinutes(30);
                br.write(sb.toString());
                sb = new StringBuilder();
                br.newLine();
            }
            System.out.println("Sikeres fájl generálás. A fájl megtalálható a projekt főkönyvtárban,a " + file + " néven.\n");
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write the file");
        }
    }

    public void importCities() {
        Validator validator = new Validator();
        String fileName = "/zip_codes_with_city_names.csv";
        TbdDAO tbdDAO = new TbdDAO();
        try (Connection connection = tbdDAO.getDs().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities (zip, city, city_part) VALUES (?, ?, ?)")) {
            InputStream is = TBD.class.getResourceAsStream(fileName);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                connection.setAutoCommit(false);
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] split = line.split(";");
                    String zip = split[0];
                    String city = split[1];
                    String cityPart = (split.length == 3) ? split[2] : null;
                    preparedStatement.setString(1, zip);
                    preparedStatement.setString(2, city);
                    preparedStatement.setString(3, cityPart);
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                System.out.println("Sikeres beolvasás és feltöltés: " + fileName.substring(1) + "\n");
            } catch (IOException ioe) {
                connection.rollback();
                throw new IllegalArgumentException("Can't read from the file.");
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException(":)", sqlException);
        }
    }

    public void riport() {
        for (int i = 0; i < 3; i++) {
            try (Connection connection = new TbdDAO().getDs().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT zip, COUNT(number_of_vaccination) AS num_of_vaccs FROM citizens WHERE number_of_vaccination = ? GROUP BY zip ORDER BY zip")) {
                preparedStatement.setInt(1, i);
                ResultSet res = preparedStatement.executeQuery();
                System.out.println(i + "x beoltottak: ");
                    while (res.next()) {
                        System.out.println("Irányítószám - " + res.getString("zip") + ": " + res.getInt("num_of_vaccs") + " személy");
                    }

            } catch (SQLException sqlException) {
                throw new IllegalStateException("No registered citizens in the DB.", sqlException);
            }
        }
        System.out.println();
    }

}
