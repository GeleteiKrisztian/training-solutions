package week13d05;

public class RowWriterType1 implements RowWriter {

    @Override
    public String writeRow(BillItem billItem) {
        return billItem.getNumber() + " " + billItem.getName() + ", darabja " + billItem.getUnitPrice();
    }
}
