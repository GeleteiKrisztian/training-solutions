package week11d02;

public class Ride {

    private int day;
    private int delivery;
    private int distance;

    public Ride(int day, int delivery, int distance) {
        this.day = day;
        this.delivery = delivery;
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getDistance() {
        return distance;
    }
}