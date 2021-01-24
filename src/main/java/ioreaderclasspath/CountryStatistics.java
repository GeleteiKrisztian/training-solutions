package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(String file) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                countries.add(new Country(split[0], Integer.parseInt(split[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public Country mostBorderCountries() {
        Country maxBorder = countries.get(0);
        for (Country item : countries) {
            if (item.getBorderCountries() > maxBorder.getBorderCountries()) {
                maxBorder = item;
            }
        }
        return maxBorder;
    }
}
