package simplequery;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private void insertActivity(Activity a, Connection connection) throws SQLException {
        try(
        PreparedStatement statement =
                connection.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)")
        ) {
            statement.setTimestamp(1, Timestamp.valueOf(a.getStartTime()));
            statement.setString(2, a.getDesc());
            statement.setString(3, a.getType().toString());
            statement.executeUpdate();
        }
    }

    private Activity selectById(int id, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM activities WHERE id = ?"))
        {
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                int resId = res.getInt("id");
                Timestamp timestamp = res.getTimestamp("start_time");
                String desc = res.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(res.getString("activity_type"));
                Activity activity = new Activity(resId, timestamp.toLocalDateTime(), desc, type);
                return activity;
            }
            throw new IllegalStateException("");
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Not found!", sqlException);
        }
    }

    private List<Activity> selectAllFromDB(Connection connection) {
        List<Activity> activities = new ArrayList<>();
        try (Statement statement = connection.createStatement()
        ) {
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

    public static void main(String[] args) {
        ActivityDAO activityDAO = new ActivityDAO();
        ActivityTrackerMain atm = new ActivityTrackerMain();
        Activity a1 = new Activity(LocalDateTime.of(2018,1,1,10,10,30), "Leírás", ActivityType.BIKING);
        Activity a2 = new Activity(LocalDateTime.of(2019,2,1,11,10), "Leírás2", ActivityType.HIKING);
        Activity a3 = new Activity(LocalDateTime.of(2020,1,1,0,15), "Leírás3", ActivityType.RUNNING);

        try(Connection conn = activityDAO.getDataSource().getConnection()
        ) {
            atm.insertActivity(a1, conn);
            atm.insertActivity(a2, conn);
            atm.insertActivity(a3, conn);

            List<Activity> activities = atm.selectAllFromDB(conn);

           Activity activity = atm.selectById(2, conn);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }
}
