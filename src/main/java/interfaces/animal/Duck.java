package interfaces.animal;

public class Duck implements Animal {

    private int leg = 2;
    private String name = "Duck";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfLegs() {
        return leg;
    }

}

