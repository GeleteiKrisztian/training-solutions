package covid;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Generation {

    public List<Citizen> readFirst16Citizen() {
        List<Citizen> citizens = new ArrayList<>();
        TbdDAO tbdDAO = new TbdDAO();
        try(PreparedStatement preparedStatement =
                    tbdDAO.getDs().getConnection().prepareStatement("SELECT * FROM citizens WHERE number_of_vaccination = 0 OR (number_of_vaccination > 0 AND number_of_vaccination < 2 AND last_vaccination < ?) ORDER BY zip, age DESC, citizen_name, number_of_vaccination ASC LIMIT 16")) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now().minusDays(15)));
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString("citizen_name");
                int zipCode = res.getInt("zip");
                byte age = res.getByte("age");
                String email = res.getString("email");
                String taj = res.getString("taj");
                byte numOfVaccs = res.getByte("number_of_vaccination");
                Timestamp lastVaccination = Optional.ofNullable(res.getTimestamp("last_vaccination")).orElse(Timestamp.valueOf(LocalDateTime.of(2037,1,1,0,0)));
                LocalDateTime lastVaccDateTime = lastVaccination.toLocalDateTime();
                Citizen citizen = new Citizen(id, name, zipCode, age, email, taj, numOfVaccs, lastVaccDateTime);
                citizens.add(citizen);
            }
            return citizens;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't read from the DB");
        }
    }

    public void generateFile() {
        List<Citizen> citizens = readFirst16Citizen();
        String file = "gen123.txt";
        try(BufferedWriter br = Files.newBufferedWriter(Path.of(file))) {
            LocalTime time = LocalTime.of(8,0);
            StringBuilder sb = new StringBuilder("Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
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

}
