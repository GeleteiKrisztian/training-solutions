package abstractclass.gamecharacter;

public class Point {

    private final long X;
    private final long Y;

    public Point(long x, long y) {
        X = x;
        Y = y;
    }

    public long getX() {
        return X;
    }

    public long getY() {
        return Y;
    }

    public long distance(Point otherPoint) {
        double firstPowPart = Math.pow(otherPoint.getX() - X,2);
        double secPowPart = Math.pow(otherPoint.getY() - Y,2);
        return (long) Math.sqrt(firstPowPart + secPowPart);
    }
}
