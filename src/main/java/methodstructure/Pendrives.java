package methodstructure;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (Pendrive item : pendrives) {
            if (item.comparePricePerCapacity(pendrive) == -1) {
                pendrive = item;
            }
        }
        return pendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (Pendrive item : pendrives) {
            if (item.cheaperThan(pendrive)) {
                pendrive = item;
            }
        }
        return pendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive item : pendrives) {
            if (item.getCapacity() == capacity) {
                item.risePrice(percent);
            }
        }
    }

}
