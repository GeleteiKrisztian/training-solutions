package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getPriceRate();
    }


    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        return null;
    }


    public List<String> getPassengerNamesOrdered() {
        List<Passenger> orderedPassengers = new ArrayList<>(passengers);
        orderedPassengers.sort(Comparator.comparing(Passenger::getName));
        List<String> res = new ArrayList<>();
        for (Passenger passenger : orderedPassengers) {
            res.add(passenger.getName());
        }
        return res;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger : passengers) {
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> passengerByClass = new HashMap<>();
        for (Passenger passenger : passengers) {
            CruiseClass cruiseClass = passenger.getCruiseClass();
            if (!passengerByClass.containsKey(cruiseClass)) {
                passengerByClass.put(cruiseClass, 1);
            } else {
                passengerByClass.put(cruiseClass, passengerByClass.get(cruiseClass) + 1);
            }
        }
        return passengerByClass;
    }
}
