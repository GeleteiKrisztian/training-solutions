package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    private MariaDbDataSource ds;

    public MenuDAO() {
        try {
            ds = new MariaDbDataSource();
            ds.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            ds.setUserName("root");
            ds.setPassword("");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("TbdDAO error.", sqlException);
        }
    }

    public MariaDbDataSource getDs() {
        return ds;
    }

    public List<Citizen> readCitizensFromDB() {
        List<Citizen> citizens = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    new MenuDAO().getDs().getConnection().prepareStatement("SELECT * FROM citizens")) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                String name = res.getString("citizen_name");
                String zipCode = res.getString("zip");
                byte age = res.getByte("age");
                String email = res.getString("email");
                String taj = res.getString("taj");

                Citizen citizen = new Citizen(name, zipCode, age, email, taj);
                citizens.add(citizen);
            }
            return citizens;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't read citizens from the DB", sqlException);
        }
    }

    public List<String> readLinesFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            lines.remove(0);
            return lines;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file.", ioe);
        }
    }
}
