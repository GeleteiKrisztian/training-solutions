package algorithmssum;

import java.util.ArrayList;
import java.util.List;

public class SalespersonMain {

    private List<Salesperson> salespersons = new ArrayList<>();

    public List<Salesperson> getSalespersons() {
        return salespersons;
    }

    public SalespersonMain(List<Salesperson> salespersons) {
        this.salespersons = salespersons;
    }

    public int sumSalespersonAmounts(List<Salesperson> salespersons) {
        int sum = 0;
        for (Salesperson item : salespersons) {
            sum += item.getAmount();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Salesperson> salespersons = new ArrayList<>();
        salespersons.add(new Salesperson("John Doe",25000));
        salespersons.add(new Salesperson("Jack Doe",30000));
        salespersons.add(new Salesperson("Jane Doe",20000));
        SalespersonMain spMain = new SalespersonMain(salespersons);

    }
}
