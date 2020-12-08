package interfacedefaultmethods;

public interface Printable {

    String BLACK = "#000000";

    int getLength();

    String getPage(int index);

    default String getColor(int index) {
        return BLACK;
    }

}
