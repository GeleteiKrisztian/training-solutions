package week06d05;

public enum BottleType {

    GLASS_BOTTLE(2), PET_BOTTLE(4);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
