package transaction;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpleupdate.ActivityType;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDAOTest {

    private ActivityDAO activityDAO;

    @BeforeEach

    void init() {
        activityDAO = new ActivityDAO();

        Flyway flyway = Flyway.configure().dataSource(activityDAO.getDataSource()).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void testInsert() {
        Activity activity = new Activity(LocalDateTime.of(2018,2,1, 10, 10), "Leírás1", ActivityType.BIKING);
        TrackPoint trackPoint = new TrackPoint(LocalDate.of(2018,2,1), 23.5, 50,1);
        Activity activity2 = new Activity(LocalDateTime.of(2019,2,28, 20, 20), "Leírás2", ActivityType.RUNNING);
        TrackPoint trackPoint2 = new TrackPoint(LocalDate.of(2019,2,28), 45.5, 10,2);
        Activity activity3 = new Activity(LocalDateTime.of(2020,1,1, 11, 10), "Leírás3", ActivityType.HIKING);
        TrackPoint trackPoint3 = new TrackPoint(LocalDate.of(2020,1,1), 24.7, 57,1);
        Activity activity5 = new Activity(LocalDateTime.of(2021,3,1, 15, 00), "Leírás4", ActivityType.BIKING);
        TrackPoint trackPoint5 = new TrackPoint(LocalDate.of(2021,3,1), 22.5, 20,3);

        activityDAO.saveActivityAndTrackPoint(activity, trackPoint, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity2, trackPoint2, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity3, trackPoint3, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity5, trackPoint5, activityDAO.getConnection());

        Activity resActivity = activityDAO.findActivityById(1);
        assertEquals("Leírás1", resActivity.getDesc());
        assertEquals(2, resActivity.getTrackPoints().size());
    }

    @Test
    void testInsertRollBack() {
        Activity activity = new Activity(LocalDateTime.of(2018,2,1, 10, 10), "Leírás1", ActivityType.BIKING);
        TrackPoint trackPoint = new TrackPoint(LocalDate.of(2018,2,1), 180, 50,1);


        Assertions.assertThrows(IllegalStateException.class, () -> {
            activityDAO.saveActivityAndTrackPoint(activity, trackPoint, activityDAO.getConnection());
        });
        assertEquals(0, activityDAO.listActivities().size());
    }

    @Test
    void listActivitiesTest() {
        Activity activity = new Activity(LocalDateTime.of(2018,2,1, 10, 10), "Leírás1", ActivityType.BIKING);
        TrackPoint trackPoint = new TrackPoint(LocalDate.of(2018,2,1), 23.5, 50,1);
        Activity activity2 = new Activity(LocalDateTime.of(2019,2,28, 20, 20), "Leírás2", ActivityType.RUNNING);
        TrackPoint trackPoint2 = new TrackPoint(LocalDate.of(2019,2,28), 45.5, 10,2);
        Activity activity3 = new Activity(LocalDateTime.of(2020,1,1, 11, 10), "Leírás3", ActivityType.HIKING);
        TrackPoint trackPoint3 = new TrackPoint(LocalDate.of(2020,1,1), 24.7, 57,1);
        Activity activity5 = new Activity(LocalDateTime.of(2021,3,1, 15, 00), "Leírás4", ActivityType.BIKING);
        TrackPoint trackPoint5 = new TrackPoint(LocalDate.of(2021,3,1), 22.5, 20,3);

        activityDAO.saveActivityAndTrackPoint(activity, trackPoint, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity2, trackPoint2, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity3, trackPoint3, activityDAO.getConnection());
        activityDAO.saveActivityAndTrackPoint(activity5, trackPoint5, activityDAO.getConnection());

        assertEquals(4, activityDAO.listActivities().size());
    }

}