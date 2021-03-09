package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Covid {

    private List<Country> countries = new ArrayList<>();

    public void readFile(Path path) {
        Map<String, CountryStat> stat = new HashMap<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String name = split[6];
                long cases = Long.parseLong(split[4]);
                long pop = Long.parseLong(split[9]);
                if (stat.containsKey(name)) {
                    CountryStat countryStat = stat.get(name);
                    countryStat.setCases(countryStat.getCases() + cases);
                } else {
                    stat.put(name, new CountryStat(cases, pop));
                }
            }
            for (Map.Entry<String, CountryStat> item : stat.entrySet()) {
                countries.add(new Country(item.getKey(), item.getValue().getCases(), item.getValue().getPopulation()));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file", ioe);
        }
    }

    public List<Country> biggestThreeOfCasePerPopulation() {
        countries.sort(Comparator.comparingDouble(c -> c.getCases() / c.getPopulation()));
        Collections.reverse(countries);
        return countries.stream().limit(3).collect(Collectors.toList());
    }

}
