package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    public final static long ALTITUDE = 5;

    private Point position;
    private int angle;
    private List<Point> points = new ArrayList<>();

    public AstroBoy(Point position) {
        this.position = position;
    }

    public void walkTo(Point position) {
        this.position = position;
        points.add(position);
    }

    public void flyTo(Point position) {
        this.position = position;
        points.add(position);
    }

    @Override
    public void liftTo(long altitude) {
        Point newPosition = new Point(this.position.getX(), this.position.getY(), altitude);
        points.add(newPosition);
        this.position = newPosition;
    }

    public void moveTo(Point position) {
        this.position = position;
        points.add(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        Point flyingPosition = new Point(position.getX(), position.getY(), ALTITUDE);
        liftTo(ALTITUDE);
        flyTo(flyingPosition);
        liftTo(0);
    }

    public void rotate(int angle) {
        if (this.angle + angle > 359) {
            this.angle = 360 - angle + this.angle;
        }
        else if (this.angle + angle < 0) {
            this.angle = Math.abs(this.angle + angle);
        } else {
            this.angle = angle;
        }
    }

    public long getAltitude() {
        return ALTITUDE;
    }

    public int getAngle() {
        return angle;
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public List<Point> getPath() {
        return points;
    }
}

