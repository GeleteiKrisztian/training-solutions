package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return new ArrayList<>(coffeeOrders);
    }

    public BigDecimal getTotalIncome() {
        return coffeeOrders.stream().flatMap(l -> l.getCoffeeList().stream()).reduce(BigDecimal.ZERO, (iden, b) -> iden.add(b.getPrice()), (t1, t2) -> t1.add(t2)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return coffeeOrders.stream().filter(dateFromList -> date.equals(LocalDate.of(dateFromList.getDateTime().getYear(),dateFromList.getDateTime().getMonth(), dateFromList.getDateTime().getDayOfMonth()))).flatMap(l -> l.getCoffeeList().stream()).reduce(BigDecimal.ZERO, (iden, b) -> iden.add(b.getPrice()), (t1, t2) -> t1.add(t2)).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream().flatMap(l -> l.getCoffeeList().stream()).filter(coffee -> coffee.getType() == type).count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
         return coffeeOrders.stream().filter(dateFromList -> dateFromList.getDateTime().isAfter(from)).limit(5).collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders.stream().filter(dateFromList -> date.equals(LocalDate.of(dateFromList.getDateTime().getYear(),dateFromList.getDateTime().getMonth(), dateFromList.getDateTime().getDayOfMonth()))).limit(5).sorted(Comparator.comparing(CoffeeOrder::getDateTime)).collect(Collectors.toList());
    }

}
