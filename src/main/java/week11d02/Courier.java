package week11d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Courier {

    public static final String SEPARATOR = " ";
    private List<Ride> rides = new ArrayList<>();

    public void process(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                rides.add(new Ride(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read File", ioException);
        }
    }

    public Ride firstRide() {
        Ride searched = rides.get(0);
        for (Ride ride : rides) {
            if (ride.getDay() <= searched.getDay()){
                if (ride.getDelivery() == 1){
                    searched = ride;
                }
            }
        }
        return searched;
    }

    public boolean[] workDays(){
        boolean[] week = new boolean[7];
        for (Ride ride : rides) {
            week[ride.getDay() - 1] = true;
        }
        return week;
    }

    public int[] dailyDistance(){
        int[] week = new int[7];
        for (Ride ride : rides) {
            week[ride.getDay() - 1] += ride.getDistance();
        }
        return week;
    }

    public List<Ride> getRides() {
        return new ArrayList<>(rides);
    }
}