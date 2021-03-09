package week15d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    void threeOfCasePerPopCountry() {
        Covid covid = new Covid();
        covid.readFile(Path.of("src/main/resources/covid_data.csv"));
        List<Country> countries = covid.biggestThreeOfCasePerPopulation();
        assertEquals(3, countries.size());
        assertEquals("Jordan", countries.get(0).getName());
       assertEquals("Zambia", countries.get(1).getName());
    }

}