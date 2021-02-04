package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private List<NavigationPoint> navigationPoints = new ArrayList<>();

    private int distance;
    private int azimut;

    public List<NavigationPoint> getNavigationList() {
        return navigationPoints;
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        if (azimut + angle >= 360) {
            azimut = (azimut + angle) - 360;
        } else if (azimut + angle < 0) {
            azimut = (azimut + angle) + 360;
        } else {
            azimut = azimut + angle;
        }
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationPoints.add(new NavigationPoint(distance,azimut));
        return this;
    }
}
