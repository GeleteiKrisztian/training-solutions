package week17d03;

import org.mariadb.jdbc.MariaDbDataSource;
import simpleupdate.Activity;
import simpleupdate.ActivityType;

import java.sql.*;
import java.time.LocalDateTime;
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

    public List<Activity> activitiesBeforeDate(LocalDateTime dateTime) {
        List<Activity> activities = new ArrayList<>();
        try(Connection conn = new simpleupdate.ActivityDAO().getDataSource().getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM activities WHERE start_time < ?")
        ) {
            statement.setTimestamp(1, Timestamp.valueOf(dateTime));
            statement.executeQuery();
            ResultSet res = statement.getResultSet();

            while (res.next()) {
                Timestamp timestamp = res.getTimestamp("start_time");
                ActivityType activityType = ActivityType.valueOf(res.getString("activity_type"));
                Activity activity = new Activity(timestamp.toLocalDateTime(), res.getString("activity_desc"), activityType);
                activities.add(activity);
            }
            return activities;

        } catch (SQLException sqlException) {
            throw new IllegalStateException("", sqlException);
        }
    }

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2020, 3, 1, 0, 0, 0);
        System.out.println(new ActivityDAO().activitiesBeforeDate(dateTime));
    }
}
