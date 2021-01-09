package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity item : activities) {
            if (item instanceof ActivityWithTrack) {
                ++counter;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity item : activities) {
            if (item instanceof ActivityWithoutTrack) {
                ++counter;
            }
        }
        return counter;
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (int i = 0; i < ActivityType.values().length; i++) {
            double totalDis = 0;
            for (Activity item : activities) {
                if (item.getType().ordinal() == i) {
                    totalDis += item.getDistance();
                }
            }
            reports.add(new Report(ActivityType.values()[i], totalDis));
        }
        return reports;
    }

}
