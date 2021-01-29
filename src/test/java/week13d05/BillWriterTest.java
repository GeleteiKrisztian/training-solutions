package week13d05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillWriterTest {

    List<BillItem> billItems = List.of(new BillItem("kenyér", 3, 5), new BillItem("hús", 5, 4));

    @Test
    public void firstFormatTest() {
        String res = new BillWriter().writeBills(billItems, new RowWriterType1());
        assertEquals("3 kenyér, darabja 5\n" +
                "5 hús, darabja 4\n", res);
    }

    @Test
    public void secFormatTest() {
        String res = new BillWriter().writeBills(billItems, new RowWriterType2());
        assertEquals("kenyér             5     3     15\n" +
                "hús             4     5     20\n", res);
    }

}