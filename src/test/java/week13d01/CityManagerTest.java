package week13d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityManagerTest {

    @Test
    void returnedCityTest() {
        CityManager cityManager = new CityManager();
        cityManager.readFile();
        City city = cityManager.citySortByName();
        assertEquals("Aba" , city.getName());
        assertEquals(8127, city.getZipCode());
    }

}