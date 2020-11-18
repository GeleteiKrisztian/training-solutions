package algorithmsmax;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson item : salespersons) {
            if (salesperson == null || item.getDifferenceFromTarget() > salesperson.getDifferenceFromTarget()) {
                salesperson = item;
            }
        }
        return salesperson;
    }

}
