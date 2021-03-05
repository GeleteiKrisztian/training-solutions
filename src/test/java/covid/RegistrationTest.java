package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    @BeforeEach
    public void setUp() {
        Flyway flyway = Flyway.configure().dataSource(new MenuDAO().getDs()).load();
        flyway.clean();
        flyway.migrate();
        new Generation().importZipAndCities();
    }

    @TempDir
    Path tempDir;

    @Test
    void testRegisterOneValidCitizen() {
        byte age = 25;
        Citizen citizen = new Citizen("John Doe", "2011", age, "johndoe@gmail.com", "123456782");
        new Registration().regCitizen(citizen);
        assertEquals(1, new MenuDAO().readCitizensFromDB().size());
    }

    @Test
    void testRegisterOneNotValidCitizen() {
        byte age = 25;
        Registration reg = new Registration();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { reg.regCitizen(new Citizen("JohnDoe", "2011", age, "johndoe@gmail.com", "123456782"));});
        Assertions.assertThrows(IllegalArgumentException.class, () -> { reg.regCitizen(new Citizen("John Doe", "1995", (byte) 3, "johndoe@gmail.com", "123456782"));});
        Assertions.assertThrows(IllegalArgumentException.class, () -> { reg.regCitizen(new Citizen("JohnDoe", "2011", age, "johndoe@gmail.com", "123456782"));});
        Assertions.assertThrows(IllegalArgumentException.class, () -> { reg.regCitizen(new Citizen("JohnDoe", "2011", age, "johndoegmail.com", "123456782"));});
        Assertions.assertThrows(IllegalArgumentException.class, () -> { reg.regCitizen(new Citizen("JohnDoe", "2011", age, "johndoe@gmail.com", "123456780"));});
        assertEquals(0, new MenuDAO().readCitizensFromDB().size());
    }

    @Test
    void registerCitizensFromFile() {
        String file = "MockDataCorona.csv";
        new Registration().regFromFile(file);
        assertEquals(11, new MenuDAO().readCitizensFromDB().size());
    }

    @Test
    void wrongFileThrowsAndRollsBack() {
        String file = "MockDataCoronaBad.csv";
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new Registration().regFromFile(file);});
        assertEquals(0, new MenuDAO().readCitizensFromDB().size());
    }
}