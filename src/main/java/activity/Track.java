package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (int i = 1; i < trackPoints.size(); i++) {
            double currLat = trackPoints.get(i).getCoordinate().getLatitude();
            if ((currLat > maxLat)) {
                maxLat = trackPoints.get(i).getCoordinate().getLatitude();
            }
        }
        for (int i = 1; i < trackPoints.size(); i++) {
            double currLon = trackPoints.get(i).getCoordinate().getLongitude();
            if (currLon > maxLon) {
                maxLon = trackPoints.get(i).getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLat, maxLon);
    }

    public Coordinate findMinimumCoordinate() {
        double minLat = trackPoints.get(0).getCoordinate().getLatitude();
        double minLon = trackPoints.get(0).getCoordinate().getLongitude();
        for (int i = 1; i < trackPoints.size(); i++) {
            double currLat = trackPoints.get(i).getCoordinate().getLatitude();
            if ((currLat < minLat)) {
                minLat = trackPoints.get(i).getCoordinate().getLatitude();
            }
        }
        for (int i = 1; i < trackPoints.size(); i++) {
            double currLon = trackPoints.get(i).getCoordinate().getLongitude();
            if (currLon < minLon) {
                minLon = trackPoints.get(i).getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLat, minLon);
    }

    public double getFullDecrease() {
        TrackPoint beforeElement = trackPoints.get(0);
        double decreaseSum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() < beforeElement.getElevation()) {
                decreaseSum += beforeElement.getElevation() - trackPoints.get(i).getElevation();
            }
            beforeElement = trackPoints.get(i);
        }
        return decreaseSum;
    }

    public double getFullElevation() {
        TrackPoint beforeElement = trackPoints.get(0);
        double eleSum = 0;
        for (int i = 1; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() > beforeElement.getElevation()) {
                eleSum += trackPoints.get(i).getElevation() - beforeElement.getElevation();
            }
            beforeElement = trackPoints.get(i);
        }
        return eleSum;
    }

    public double getDistance() {
        double totalDistance = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
                totalDistance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
            }
        return totalDistance;
    }

    public void loadFromGpx(InputStream is) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            Coordinate coordinate = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<trkpt")) {
                    String latStr = line.substring(12,22);
                    String lonStr = line.substring(29,39);
                    double lat = Double.parseDouble(latStr);
                    double lon = Double.parseDouble(lonStr);
                    coordinate = new Coordinate(lat, lon);
                }
                if (line.startsWith("<ele")) {
                    String eleStr = line.substring(5,10);
                    double ele = Double.parseDouble(eleStr);
                    TrackPoint trackPoint = new TrackPoint(coordinate, ele);
                    trackPoints.add(trackPoint);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public double getRectangleArea() {
        Coordinate minCoordinate = findMinimumCoordinate();
        Coordinate maxCoordinate = findMaximumCoordinate();
        double area = (maxCoordinate.getLatitude() - minCoordinate.getLatitude()) * (maxCoordinate.getLongitude() - minCoordinate.getLongitude());
        return area;
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

}
