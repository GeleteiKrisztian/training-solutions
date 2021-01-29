package week13d05;

import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, RowWriter rowWriter) {
        StringBuilder sb = new StringBuilder();
        for (BillItem item : billItems) {
            sb.append(rowWriter.writeRow(item) + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BillWriter().writeBills(List.of(new BillItem("kenyér", 3, 5), new BillItem("Hús", 5, 4)), new RowWriterType2()));
    }
}
