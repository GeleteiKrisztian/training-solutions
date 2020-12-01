package constructoroverloading;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> startingTimes;

    public BusTimeTable(List<SimpleTime> timeTable) {
        startingTimes = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> times = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            times.add(new SimpleTime(i,everyMinute));
        }
        startingTimes = times;
    }

    public List<SimpleTime> getTimeTable() {
        return startingTimes;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime item : startingTimes) {
            if ((item.getHours() >= actual.getHours()) && (item.getMinutes() >= actual.getMinutes())) {
                return item;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

}
