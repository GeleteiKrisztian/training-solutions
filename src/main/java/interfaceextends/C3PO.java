package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot {

    private Point position;
    private int angle;
    private List<Point> points = new ArrayList<>();

    public C3PO(Point position) {
        this.position = position;
    }

    public void moveTo(Point position){
       walkTo(position);
    }

    public void fastMoveTo(Point position) {
        walkTo(position);
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

    private void walkTo(Point position) {
        this.position = position;
        points.add(position);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public List<Point> getPath() {
        return points;
    }
}
