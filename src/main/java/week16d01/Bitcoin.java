package week16d01;

import java.time.LocalDate;

public class Bitcoin implements Comparable<Bitcoin> {

    private int price;
    private LocalDate date;

    public Bitcoin(int price, LocalDate date) {
        this.price = price;
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDateTime() {
        return date;
    }

    @Override
    public int compareTo(Bitcoin o) {
        return date.compareTo(o.getDateTime());
    }
}
