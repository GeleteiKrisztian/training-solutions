package transaction;

import org.mariadb.jdbc.MariaDbDataSource;
import simpleupdate.ActivityType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    private MariaDbDataSource dataSource = new MariaDbDataSource();
    private Connection connection;

    public ActivityDAO() {
        try {
            //
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUserName("employees");
            dataSource.setPassword("employees");
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        return connection;
    }

    public void saveActivityAndTrackPoint(Activity activity, TrackPoint trackPoint, Connection connection) {
        try {
            saveActivity(activity, connection);
            saveTrackPoint(trackPoint, connection);
            //
            connection.commit();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("");
        }
    }

    private void saveActivity(Activity activity, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO activities (start_time,activity_desc, activity_type) VALUES (?, ?, ?)")) {

            Timestamp timestamp = Timestamp.valueOf(activity.getStartTime());
            statement.setTimestamp(1, timestamp);
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw sqlException;
        }
    }

    private void saveTrackPoint(TrackPoint trackPoint, Connection connection) throws SQLException {

        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO track_point (`date`, lat, lon, activity_id) VALUES (?, ?, ?, ?)")) {
            if (!isCorrectTrackPoint(trackPoint)) {
                connection.rollback();
                throw new IllegalStateException("Bad coordinates");
            }
                Timestamp timestamp2 = Timestamp.valueOf(trackPoint.getDate().atTime(0,0));
                statement.setTimestamp(1, timestamp2);
                statement.setDouble(2, trackPoint.getLat());
                statement.setDouble(3, trackPoint.getLon());
                statement.setInt(4, trackPoint.getActivityId());
                statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw sqlException;
        }
    }

    private boolean isCorrectTrackPoint(TrackPoint trackPoint) {
        if ((trackPoint.getLat() >= -90 && trackPoint.getLat() <= 90) && (trackPoint.getLon() >= -180 && trackPoint.getLon() <= 180)) {
            return true;
        }
        return false;
    }

    public Activity findActivityById(int id) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM activities JOIN track_point ON activities.id = track_point.activity_id WHERE activity_id = ?")) {
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();

            Activity activity = null;
            while (res.next()) {
                if (res.getInt("activities.id") == id) {
                    int resId = res.getInt(id);
                    Timestamp timestamp = res.getTimestamp("start_time");
                    String desc = res.getString("activity_desc");
                    ActivityType type = ActivityType.valueOf(res.getString("activity_type"));
                    activity = new Activity(resId, timestamp.toLocalDateTime(), desc, type);
                }
                    int trackId = res.getInt("track_point.activity_id");
                    Timestamp trackTimestamp = res.getTimestamp("date");
                    LocalDate date = trackTimestamp.toLocalDateTime().toLocalDate();
                    double lat = res.getDouble("lat");
                    double lon = res.getDouble("lon");
                    int actId = res.getInt("activity_id");

                    TrackPoint trackPoint = new TrackPoint(trackId, date, lat, lon, actId);
                    trackPoints.add(trackPoint);
            }
            activity.addTrackPoints(trackPoints);
                return activity;

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public List<Activity> listActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet res = statement.executeQuery("SELECT * FROM activities");
            while (res.next()) {
                int resId = res.getInt("id");
                Timestamp timestamp = res.getTimestamp("start_time");
                String desc = res.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(res.getString("activity_type"));
                Activity activity = new Activity(resId, timestamp.toLocalDateTime(), desc, type);
                activities.add(activity);
            }
            return activities;
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Not found!", sqlException);
        }
    }

}
