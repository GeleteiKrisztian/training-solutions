package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

   static double totalValue(List<Valued> valueds) {
        double total = 0;
        for (Valued item : valueds) {
            total += item.getValue();
        }
        return total;
    }

}
