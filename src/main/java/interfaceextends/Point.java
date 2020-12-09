package interfaceextends;

public class Point {

    private final long X;
    private final long Y;
    private final long Z;

    public Point(long x, long y, long z) {
        X = x;
        Y = y;
        Z = z;
    }

    public long getX() {
        return X;
    }

    public long getY() {
        return Y;
    }

    public long getZ() {
        return Z;
    }

}
