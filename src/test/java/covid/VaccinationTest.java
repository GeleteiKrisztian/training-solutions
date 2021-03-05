package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationTest {

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
    void readCitizensToVaccinateByZipOrderTest() {
        String file = "MockDataCorona.csv";
        String zip = "2011";
        new Registration().regFromFile(file);
        List<Citizen> citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        assertEquals(2, citizens.size());
        assertEquals("Daryl Chasier", citizens.get(0).getFullName());
    }

    @Test
    void vaccinationTest() {
        String file = "MockDataCorona.csv";
        String zip = "2011";
        String taj = "123456782";
        new Registration().regFromFile(file);
        List<Citizen> citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        Citizen citizen = new Vaccination().findCitizenByTajBetween16(taj, citizens);
        assertEquals(2, citizens.size());

        new Vaccination().doVaccination(citizen, VaccineType.TYPE1, "Megjegyzés");
        citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        assertEquals(1, citizens.size());
    }

    @Test
    void excludeFromVaccinationTest() {
        String file = "MockDataCorona.csv";
        String zip = "2011";
        String taj = "123456782";
        new Registration().regFromFile(file);
        List<Citizen> citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        Citizen citizen = new Vaccination().findCitizenByTajBetween16(taj, citizens);
        assertEquals(2, citizens.size());

        new Vaccination().excludeCitizenFromVaccination(citizen, "Megjegyzés");
        List<Citizen> citizensAfterExclude = new Generation().readFirst16CitizenToVaccinate(zip);
        assertEquals(2, citizensAfterExclude.size());
    }

    @Test
    void excludeFromVaccinationAgainThrowsTest() {
        String file = "MockDataCorona.csv";
        String zip = "2011";
        String taj = "123456782";
        new Registration().regFromFile(file);
        List<Citizen> citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        Citizen citizen = new Vaccination().findCitizenByTajBetween16(taj, citizens);
        new Vaccination().excludeCitizenFromVaccination(citizen, "Megjegyzés");
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new  Vaccination().excludeCitizenFromVaccination(citizen, "Megjegyzés");});
    }
}