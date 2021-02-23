package simpleupdate;

import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    private void insertActivity(Activity a, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, Timestamp.valueOf(a.getStartTime()));
        statement.setString(2, a.getDesc());
        statement.setString(3, a.getType().toString());
        statement.executeUpdate();
    }

    public static void main(String[] args) {
        ActivityTrackerMain atm = new ActivityTrackerMain();
        ActivityDAO activityDAO = new ActivityDAO();
        Activity a1 = new Activity(LocalDateTime.of(2018,1,1,10,10,0), "Leírás", ActivityType.BIKING);
        Activity a2 = new Activity(LocalDateTime.of(2019,2,1,11,10), "Leírás2", ActivityType.HIKING);
        Activity a3 = new Activity(LocalDateTime.of(2020,1,1,0,15), "Leírás3", ActivityType.RUNNING);


        try(Connection conn = activityDAO.getDataSource().getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")
        ) {
            atm.insertActivity(a1, statement);
            atm.insertActivity(a2, statement);
            atm.insertActivity(a3, statement);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }
}
