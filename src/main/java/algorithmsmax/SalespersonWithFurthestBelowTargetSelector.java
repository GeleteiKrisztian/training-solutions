package algorithmsmax;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson item : salespersons) {
            if (salesperson == null || item.getDifferenceFromTarget() < salesperson.getDifferenceFromTarget()) {
                salesperson = item;
            }
        }
        return salesperson;
    }

}
