package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {

    private List<String> pages = new ArrayList<>();

    public void addPage(String s) {
        pages.add(s);
    }

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int index) {
       return pages.get(index);
    }

    public String getColor(int index) {
        return Printable.BLACK;
    }

}
