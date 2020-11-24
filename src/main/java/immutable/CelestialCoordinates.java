package immutable;

public class CelestialCoordinates {

    private final int X;
    private final int Y;
    private final int Z;

    public CelestialCoordinates(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getZ() {
        return Z;
    }

    @Override
    public String toString() {
        return String.format("CelestialCoordinates: x=%d, y=%d, z=%d",X,Y,Z);
    }

}
