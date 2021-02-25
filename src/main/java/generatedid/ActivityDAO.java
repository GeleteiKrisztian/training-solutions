package generatedid;

import org.mariadb.jdbc.MariaDbDataSource;
import simpleupdate.Activity;
import simpleupdate.ActivityType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO {

    private MariaDbDataSource dataSource = new MariaDbDataSource();

    public ActivityDAO() {
        try {
            //
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUserName("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }

    public void saveActivity(Activity activity) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO activities (start_time,activity_desc, activity_type) VALUES (?, ?, ?)"))
        {
            Timestamp timestamp = Timestamp.valueOf(activity.getStartTime());
            statement.setTimestamp(1, timestamp);
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getType().toString());
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public Activity findActivityById(long id) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM activities WHERE id = ?"))
        {
            statement.setInt(1, (int) id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                int resId = res.getInt("id");
                Timestamp timestamp = res.getTimestamp("start_time");
                String desc = res.getString("activity_desc");
                ActivityType type = ActivityType.valueOf(res.getString("activity_type"));
                Activity activity = new Activity(resId, timestamp.toLocalDateTime(), desc, type);
                return activity;
            }
            throw new IllegalArgumentException("No record with id " + id);

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
