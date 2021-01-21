package ioreadwritestring;

public class Temperatures {

    public static final int MONTHLYSTAT = 30;
    private byte[] temps;

    public Temperatures(byte[] temps) {
        this.temps = temps;
    }

    public double getYearAverage() {
        int sum = 0;
        for (byte item : temps) {
            sum += item;
        }
        return (double) sum / temps.length;
    }

    public double getMonthAverage() {
        int sum = 0;
        for (int i = temps.length - 1; i > temps.length - 1 - MONTHLYSTAT; i--) {
            sum += temps[i];
        }
        return (double) sum / MONTHLYSTAT;
    }

    public byte[] getData() {
        return temps;
    }
}
