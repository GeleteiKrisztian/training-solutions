package simplequery;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class ActivityDAO {

    private MariaDbDataSource dataSource = new MariaDbDataSource();

    public ActivityDAO() {
        try {
            //
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUserName("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }
}
