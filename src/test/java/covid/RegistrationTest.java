package covid;


import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    @BeforeEach
    public void setUp() {
        Flyway flyway = Flyway.configure().dataSource(new TbdDAO().getDs()).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void testRegOneCitizen() {

    }

}