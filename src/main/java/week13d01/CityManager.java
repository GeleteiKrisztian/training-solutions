package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CityManager {

    private List<City> cities = new ArrayList<>();

    public void readFile() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(CityManager.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")))) {
            String line;
            while((line = br.readLine()) != null) {
                if (line.startsWith("IRSZ")) {
                    continue;
                }
                String[] split = line.split(";");
                if (split.length < 3) {
                    cities.add(new City(Integer.parseInt(split[0]), split[1]));
                } else {
                    cities.add(new City(Integer.parseInt(split[0]), split[1], split[2]));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public City citySortByName() {
        List<City> cityList = new ArrayList<>(cities);
        cityList.sort(Comparator.comparing(City::getName));
        return cityList.get(0);
    }

    public List<City> getCities() {
        return new ArrayList<>(cities);
    }
}
