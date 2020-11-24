package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

private List<Satellite> satellites = new ArrayList<>();


    public void registerSatellite(Satellite satellite) {
        if (isEmpty(satellite)) {
            throw new NullPointerException("Parameter must not be null!");
        }
        Satellite satelliteParam = satellite;
        satellites.add(satelliteParam);
    }

      public Satellite findSatelliteByRegisterIdent(String regNum) {
        for (Satellite item : satellites) {
            if (item.getRegNum().equals(regNum)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!XXX123");
      }

      private boolean isEmpty(Satellite s) {
        if (s == null) {
            return true;
        }
        return false;
      }

    @Override
    public String toString() {
        return satellites.toString();
    }

}
