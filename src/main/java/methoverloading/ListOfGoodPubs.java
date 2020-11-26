package methoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> pubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        pubs = new ArrayList<>(goodPubs);
    }

    public Pub findTheBest() {
        Time time = new Time();
        int openTimeSeconds = 24 * 60 * 60;
        Pub pub = pubs.get(0);
        for (Pub item : pubs) {
            if (time.timeToSec(item.getOpenFrom()) < openTimeSeconds) {
                pub = item;
                openTimeSeconds = time.timeToSec(item.getOpenFrom());
            }
        }
        return pub;
    }

}
