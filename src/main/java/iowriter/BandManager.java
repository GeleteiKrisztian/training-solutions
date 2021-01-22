package iowriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try(BufferedReader br = Files.newBufferedReader(inputFile)) {
            String line;
            while((line = br.readLine()) != null) {
                String[] split = line.split(";");
                bands.add(new Band(split[0], Integer.parseInt(split[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file.", ioe);
        }
    }

    public void writeBandsBefore(Path path, int year) {
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            List<Band> bandList = filterByYear(year);
            for (Band item : bandList) {
                bw.write(item.toString() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    private List<Band> filterByYear(int year) {
        List<Band> bands = new ArrayList<>();
        for (Band item : this.bands) {
            if (item.getYear() == year) {
                bands.add(item);
            }
        }
        return bands;
    }

}
