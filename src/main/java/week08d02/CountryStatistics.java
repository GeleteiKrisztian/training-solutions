package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countryStatistics;

    public List<Country> getCountryStatistics() {
        return new ArrayList<>(countryStatistics);
    }

    public void readData(Path file) {
        List<Country> statistics = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {
               String[] split = line.split(" ");
               String name = split[0];
               long populationVar = Long.parseLong(split[1]);
               int flagColor = Integer.parseInt(split[2]);
               int neightboringCountriesVar = Integer.parseInt(split[3]);
               statistics.add(new Country(name,populationVar,flagColor,neightboringCountriesVar));
            }
            countryStatistics = statistics;
        } catch (IOException ex) {
            throw new IllegalArgumentException("Can't read the file.",ex);
        }
    }

    public Country maxPopulation(List<Country> stats) {
        Country country = null;
        for (Country item : stats) {
            if (country == null || item.getPopulation() > country.getPopulation()) {
                country = item;
            }
        }
        return country;
    }

}
