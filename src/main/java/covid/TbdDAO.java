package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TbdDAO {

    private MariaDbDataSource ds;

    public TbdDAO() {
        try {
            ds = new MariaDbDataSource();
            ds.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            ds.setUserName("root");
            ds.setPassword("m");
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
                    new TbdDAO().getDs().getConnection().prepareStatement("SELECT * FROM citizens")) {
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
            throw new IllegalStateException("Can't read citizens from the DB");
        }
    }
}
