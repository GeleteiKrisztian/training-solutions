package week13d05;

public class RowWriterType2 implements RowWriter {
    @Override
    public String writeRow(BillItem billItem) {
        return String.format("%s %13d %5d %6d", billItem.getName(),billItem.getUnitPrice(),billItem.getNumber(), billItem.getNumber() * billItem.getUnitPrice());
    }
}
