package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.SQLException;

public class TbdDAO {

    private MariaDbDataSource ds;

    public TbdDAO() {
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

}
