package attributes.bill;

public class BillMain {

    public static void main(String[] args) {

        Bill bill = new Bill();
        bill.addItem(new Item("Samsung S8",100,120000));
        bill.addItem(new Item("Xiaomi",5,80000));
        bill.addItem(new Item("Monitor",2,30000));
        System.out.println(bill.calculateTotalPrice());
    }
}
