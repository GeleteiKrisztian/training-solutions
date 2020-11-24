package immutable;

public class Satellite {

    private CelestialCoordinates celestialCoordinates;
    private String regNum;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent){
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.celestialCoordinates = destinationCoordinates;
        this.regNum = registerIdent;
    }

    public String getRegNum() {
        return regNum;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        int x = celestialCoordinates.getX() + diff.getX();
        int y = celestialCoordinates.getY() + diff.getY();
        int z = celestialCoordinates.getZ() + diff.getZ();
        CelestialCoordinates celCoordinatesNew = new CelestialCoordinates(x,y,z);
        celestialCoordinates = celCoordinatesNew;
    }

    private boolean isEmpty(String s) {
        if (s.isBlank()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s: CelestialCoordinates: x=%d, y=%d, z=%d",regNum,celestialCoordinates.getX(),celestialCoordinates.getY(),celestialCoordinates.getZ());
    }
}
