package week06d05;

public class Bottle {

    private BottleType type;
    private int filledUntil;

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }

    private Bottle(BottleType type) {
        this.type = type;
    }

    public void fill(int fillAmount) {
        if (filledUntil + fillAmount > type.getMaximumAmount()) {
           throw new IllegalArgumentException("Can't fill the bottle.");
        } else {
            filledUntil += fillAmount;
        }
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

}
