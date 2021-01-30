package datenewtypes;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class WorkHoursCalculatorTest {

    @Test
    void zeroWorkHourTest() {
        assertEquals("PT0S", new WorkHoursCalculator().getWorkDuration().toString());
    }

    @Test
    void addWorkDurationTest() {
        WorkHoursCalculator whc = new WorkHoursCalculator();
        whc.addWorkTime(Duration.parse("PT1H"));
        assertEquals("PT1H", whc.getWorkDuration().toString());
    }

    @Test
    void addWorkStringTest() {
        WorkHoursCalculator whc = new WorkHoursCalculator();
        whc.addWorkTime("PT2H");
        assertEquals("PT2H", whc.getWorkDuration().toString());
    }

    @Test
    void addWorkIntsTest() {
        WorkHoursCalculator whc = new WorkHoursCalculator();
        whc.addWorkTime(1,2,5);
        assertEquals("PT1H2M5S", whc.getWorkDuration().toString());
    }

    @Test
    void calculateHoursTest() {
        WorkHoursCalculator whc = new WorkHoursCalculator();
        whc.addWorkTime(4,65,5);
        whc.calculateWorkHours();
        assertEquals("PT5H5M5S",  whc.getWorkDuration().toString());
    }
}