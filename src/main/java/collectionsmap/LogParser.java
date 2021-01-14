package collectionsmap;

import java.time.LocalDate;
import java.util.*;

public class LogParser {
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_LOGIN = 2;
    public static final int NUMBER_OF_FIELDS = 3;
    public static final String LOG_SEPARATOR = ":";

    Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> res = new HashMap<>();
        Scanner scanner = new Scanner(log).useDelimiter(LOG_SEPARATOR);
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(":");
            if (split.length != NUMBER_OF_FIELDS) {
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            LocalDate date = parseToDate(split[POSITION_OF_DATE]);
            fillMap(res, new Entry(split[POSITION_OF_IP], date, split[POSITION_OF_LOGIN]));
        }
        return res;
    }

    private void fillMap(Map<String, List<Entry>> elements, Entry entry) {
        if (!elements.containsKey(entry.getIpAddress())) {
            elements.put(entry.getIpAddress(), new ArrayList<>());
        }
        elements.get(entry.getIpAddress()).add(entry);
    }

    private LocalDate parseToDate(String s) {
        String[] split = s.split("-");
        if (split.length != 3) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day);
    }
}
