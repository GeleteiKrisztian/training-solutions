package algorithmsmax;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson item : salespersons) {
            if (salesperson == null || item.getAmount() > salesperson.getAmount()) {
                salesperson = item;
            }
        }
        return salesperson;
    }

}
