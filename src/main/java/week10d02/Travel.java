package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Travel {

    public int getStopWithMax(InputStream is) {
        List<Integer> stops = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stops.add(0);
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String busStop = line.split(" ")[0];
                int covertBusStop = Integer.parseInt(busStop);
                stops.set(covertBusStop, stops.get(covertBusStop) + 1);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }
        int max = 0;
        for (Integer item : stops) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

}
