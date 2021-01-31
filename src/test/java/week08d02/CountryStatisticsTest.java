package week08d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryStatisticsTest {
    Path file = Path.of("countries.txt");
    CountryStatistics countryStatistics = new CountryStatistics();

    @Test
    void rowTest() {
        countryStatistics.readData(file);
        assertEquals(11,countryStatistics.getCountryStatistics().size());
    }

    @Test
    void maxPopulationTest() {
        countryStatistics.readData(file);
        List<Country> countries = countryStatistics.getCountryStatistics();
        Country country = countryStatistics.maxPopulation(countries);
        assertEquals("Kongoi_Demokratikus_Koztarsasag",country.getCountryName());
    }

}
