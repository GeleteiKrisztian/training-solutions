package schoolrecords;

public enum MarkType {
    A(5, "excellent"), B(4, "very good"), C(3, "improvement needed"), D(2, "close fail"), F(1, "fail");
    //A, B, C, D, E, F;

    private int value;
    private String discription;

    MarkType(int value, String discription) {
        this.value = value;
        this.discription = discription;
    }

    public int getValue() {
        return value;
    }

    public String getDiscription() {
        return discription;
    }

}
