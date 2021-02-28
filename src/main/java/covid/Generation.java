package covid;

import javax.sound.midi.Soundbank;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generation {

    public List<Citizen> readFirst16CitizenByZip() {
        System.out.println("Add meg az irányítószámot a kereséshez: ");
        String zipStr = new Scanner(System.in).nextLine();
        int zip = Integer.parseInt(zipStr);

        List<Citizen> citizens = new ArrayList<>();
        TbdDAO tbdDAO = new TbdDAO();
        try(PreparedStatement preparedStatement =
                    tbdDAO.getDs().getConnection().prepareStatement("SELECT * FROM citizens WHERE zip = ? AND last_vaccination < ? ORDER BY age DESC, citizen_name, number_of_vaccination ASC  LIMIT 16")) {
            preparedStatement.setInt(1, zip);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now().minusDays(15)));
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString("citizen_name");
                int zipCode = res.getInt("zip");
                byte age = res.getByte("age");
                String email = res.getString("email");
                String taj = res.getString("taj");
                byte numOfVaccs = res.getByte("number_of_vaccination");
                Timestamp timestamp = res.getTimestamp("last_vaccination");
                LocalDateTime lastVaccDateTime = timestamp.toLocalDateTime();
                Citizen citizen = new Citizen(id, name, zipCode, age, email, taj, numOfVaccs, lastVaccDateTime);
                citizens.add(citizen);
            }
            return citizens;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't read from the DB");
        }
    }

    public void generateFileByZip() {

    }
}
