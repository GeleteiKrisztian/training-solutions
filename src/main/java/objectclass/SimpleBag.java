package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List<Object> items = new ArrayList<>();
    private int cursor = -1;

    public SimpleBag() {
    }

    public void putItem(Object item) {
    if (item == null) {
        throw new IllegalArgumentException("");
    }
    items.add(item);
    }

    public boolean isEmpty() {
        return items.size() == 0 ? true : false;
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return cursor < items.size()-1;
    }

    public Object next() {
        return items.get(++cursor);
    }

    public boolean contains(Object item) {
        return items.contains(item);
    }

    public int getCursor() {
        return cursor;
    }

}
