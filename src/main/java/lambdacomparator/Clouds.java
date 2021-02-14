package lambdacomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clouds {

    public Clouds() {
    }


    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudsPar) {
        List<CloudStorage> clouds = new ArrayList<>(cloudsPar);
        clouds.sort(Comparator.comparing(CloudStorage::getProvider, (s, t) -> s.toLowerCase().compareTo(t.toLowerCase())));
        return clouds.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudsPar) {
        List<CloudStorage> clouds = new ArrayList<>(cloudsPar);
        clouds.sort(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.naturalOrder())).thenComparing(CloudStorage::getPrice));
        return clouds.get(0);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudsPar) {
        List<CloudStorage> clouds = new ArrayList<>(cloudsPar);
        clouds.sort(Comparator.reverseOrder());


        List<CloudStorage> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (clouds.size() > i) {
                res.add(clouds.get(i));
            } else {
                break;
            }
        }
        return res;
    }

}
