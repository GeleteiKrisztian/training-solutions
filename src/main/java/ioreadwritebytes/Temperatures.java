package ioreadwritebytes;

public class Temperatures {

    public static final int LASTDAYS = 30;
    private byte[] temperatures;

    public Temperatures(byte[] temperatures) {
        this.temperatures = temperatures;
    }

    public double getYearAverage() {
        int sum = 0;
        for (Byte item : temperatures) {
            sum += item;
        }
        return (double) sum / temperatures.length;
    }

    public double getMonthAverage() {
        int sum = 0;
        for (int i = temperatures.length - LASTDAYS; i < temperatures.length; i++) {
            sum += temperatures[i];
        }
        return (double) sum / LASTDAYS;
    }

    public byte[] getData() {
        return temperatures;
    }
}
