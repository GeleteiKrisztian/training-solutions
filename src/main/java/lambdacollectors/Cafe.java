package lambdacollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders = new ArrayList<>();

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return List.copyOf(coffeeOrders);
    }

    Map<CoffeeType, Long> getCountByCoffeeType() {
        return coffeeOrders.stream().flatMap(l -> l.getCoffeeList().stream()).collect(Collectors.groupingBy(c -> c.getType(), Collectors.counting()));
    }

    public double getAverageOrder() {
        return coffeeOrders.stream().collect(Collectors.averagingInt(l -> l.getCoffeeList().size()));
    }
}
