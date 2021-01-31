package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples(String file) {
        List<String> titles = new ArrayList<>();
        try (BufferedReader bis = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream(file)))) {
            String line = null;
            while ((line = bis.readLine()) != null) {
                if (line.startsWith("#")) {
                    titles.add(line);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file.", ioe);
        }
        return titles;
    }

}
