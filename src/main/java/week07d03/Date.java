package week07d03;

public class Date {

    private final int YEAR;
    private final int MONTH;
    private final int DAY;

    private Date(int YEAR, int MONTH, int DAY) {
        this.YEAR = YEAR;
        this.MONTH = MONTH;
        this.DAY = DAY;
    }

    public int getYEAR() {
        return YEAR;
    }

    public int getMONTH() {
        return MONTH;
    }

    public int getDAY() {
        return DAY;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, MONTH, DAY);
    }

    public Date withMonth(int month) {
        return new Date(YEAR, month, DAY);
    }

    public Date withDay(int day) {
        return new Date(YEAR, MONTH, day);
    }

    @Override
    public String toString() {
        return YEAR + "/" + MONTH + "/" + DAY;
    }

}
