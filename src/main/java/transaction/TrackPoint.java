package transaction;

import java.time.LocalDate;

public class TrackPoint {

    private int id;
    private LocalDate date;
    private double lat;
    private double lon;
    private int activityId;

    public TrackPoint(LocalDate time, double lat, double lon, int activityId) {
        this.date = time;
        this.lat = lat;
        this.lon = lon;
        this.activityId = activityId;
    }

    public TrackPoint(int id, LocalDate time, double lat, double lon, int activityId) {
        this(time, lat, lon, activityId);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getActivityId() {
        return activityId;
    }
}
