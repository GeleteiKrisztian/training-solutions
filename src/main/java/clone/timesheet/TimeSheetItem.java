package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        employee = timeSheetItem.employee;
        project = timeSheetItem.project;
        from = timeSheetItem.from;
        to = timeSheetItem.to;
    }

    public TimeSheetItem(TimeSheetItem another, LocalDate date) {
        employee = another.employee;
        project = another.project;
        from = LocalDateTime.of(date, LocalTime.of(another.from.getHour(), another.from.getMinute(), another.from.getSecond()));
        to = LocalDateTime.of(date, LocalTime.of(another.to.getHour(), another.to.getMinute(), another.to.getSecond()));
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate date) {
        return new TimeSheetItem(timeSheetItem, date);
    }
}
