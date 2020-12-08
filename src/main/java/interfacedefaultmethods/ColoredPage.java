package interfacedefaultmethods;

public class ColoredPage {

    private final String CONTENT;
    private final String COLOR;

    public ColoredPage(String CONTENT, String COLOR) {
        this.CONTENT = CONTENT;
        this.COLOR = COLOR;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public String getCOLOR() {
        return COLOR;
    }

}
