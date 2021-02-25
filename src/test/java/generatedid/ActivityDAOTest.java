package generatedid;

import architectures.ActivityDAO;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpleupdate.Activity;
import simpleupdate.ActivityType;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDAOTest {

    private architectures.ActivityDAO activityDAO;

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
        activityDAO.saveActivity(activity);
        List<Activity> activities = activityDAO.listActivities();
        assertEquals(1 , activities.size());
        assertEquals("Leírás1", activities.get(0).getDesc());
    }

    @Test
    void testSelectById() {
        Activity activity = new Activity(LocalDateTime.of(2018,2,1, 10, 10), "Leírás1", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2020,3,1, 10, 30), "Leírás2", ActivityType.BIKING);
        activityDAO.saveActivity(activity);
        activityDAO.saveActivity(activity2);
        Activity res = activityDAO.findActivityById(2L);
        assertEquals(activity2.getDesc(), res.getDesc());
        assertEquals(activity2.getStartTime(), res.getStartTime());
    }

    @Test
    void testInsertWithReturn() {
        Activity activity = activityDAO.saveActivity(new Activity(LocalDateTime.of(2018,2,1, 10, 10), "Leírás1", ActivityType.BIKING));
        assertEquals(1, activity.getId());
    }
}