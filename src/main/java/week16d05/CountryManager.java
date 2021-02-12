package week16d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class CountryManager {

    private List<Country> countries = new ArrayList<>();
    private Map<String, Integer> countryCases = new HashMap<>();

    public void read(String file) {
        Path path = Path.of(file);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                LocalDate date = dateFormatter(split[0]);
                int caseNum = Integer.parseInt(split[2]);
                String country = split[4];
                int notificationRatePer100_000population14Days = Integer.parseInt(split[9]);
                double populationPerCase = notificationRatePer100_000population14Days / (double) caseNum;
                countries.add(new Country(date, split[1], caseNum, Integer.parseInt(split[3]), split[4], split[5], split[6], Integer.parseInt(split[7]), split[8], Integer.parseInt(split[9]), populationPerCase));
                if (!countryCases.containsKey(country)) {
                    countryCases.put(country, 0);
                } else {
                    countryCases.put(country, countryCases.get(country) + caseNum);
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException(".");
        }
    }

    private LocalDate dateFormatter(String s) {
        String[] date = s.split("/");
        return LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
    }

    public List<String> FirstThreeCountryByPopulationPerCaseDesc() {
        List<CountryManagerHelper> countryManagerHelpers = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            countryManagerHelpers.add(new CountryManagerHelper(country.getCountriesAndTerritiories(), countryCases.get(country.getCountriesAndTerritiories()), country.getPopulationPerCaseRate(), i));
        }
        countryManagerHelpers.sort(Comparator.naturalOrder());
        List<String> result = new ArrayList<>();
        int firstResultindex = countryManagerHelpers.size() - 1;
        int secResultindex = countryManagerHelpers.size() - 2;
        int thirdResultindex = countryManagerHelpers.size() - 3;

        result.add(countries.get(countryManagerHelpers.get(firstResultindex).getIndex()).getCountriesAndTerritiories());
        result.add(countries.get(countryManagerHelpers.get(secResultindex).getIndex()).getCountriesAndTerritiories());
        result.add(countries.get(countryManagerHelpers.get(thirdResultindex).getIndex()).getCountriesAndTerritiories());

        return result;
    }

}
