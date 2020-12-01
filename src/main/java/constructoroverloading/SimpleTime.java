package constructoroverloading;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours) {
        this.hours = hours;
    }
    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public SimpleTime(SimpleTime time) {
        this(time.getHours(), time.getMinutes());
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        int difference = (hours * 60 + minutes) - (time.getHours() * 60 + time.getMinutes());
        return difference;
    }
    public String toString() {
        return hours + ":" + minutes;
    }
}
