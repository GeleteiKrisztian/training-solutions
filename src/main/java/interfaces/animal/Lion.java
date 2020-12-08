package interfaces.animal;

public class Lion implements Animal {

    private int leg = 4;
    private String name = "Lion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfLegs() {
        return leg;
    }

}
