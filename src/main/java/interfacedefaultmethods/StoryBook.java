package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {

    private List<ColoredPage> coloredPages = new ArrayList<>();

    public void addPage(String page,String color) {
        coloredPages.add(new ColoredPage(page,color));
    }

    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    /*
            if (coloredPages.size() > 0) {
        ColoredPage item = coloredPages.get(index);
        String res = null;
        if (item.getCOLOR().equals(BLACK)) {
            res = item.getCONTENT();
        } else {
            res = "[" + item.getCOLOR() + "]".concat(item.getCONTENT());
        }
        return res;
    }
        return "";
     */

    public String getPage(int index) {
       return coloredPages.get(index).getCONTENT();
    }

    public String getColor(int index) {
        return coloredPages.get(index).getCOLOR();
    }

}
