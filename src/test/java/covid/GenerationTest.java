package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerationTest {

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
    void generateFileToVaccinateTest() {
        String zip = "2011";
        Path file = tempDir.resolve("data.csv");
        Citizen citizen = new Citizen("John Doe", zip, (byte) 25, "johndoe@gmail.com", "123456782");
        new Registration().regCitizen(citizen);
        new Generation().generateFirst16CitizenToVaccinateFile(zip, file.toString());
        List<String> lines = new MenuDAO().readLinesFromFile(file);
        assertEquals(1, lines.size());
    }
}
