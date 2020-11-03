package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance performance = new Performance(LocalDate.of(2020,11,02),"Queen", LocalTime.of(12,45),LocalTime.of(15,00));
        System.out.println(performance.getInfo());
    }
}
