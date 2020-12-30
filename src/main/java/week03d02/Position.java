package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        Position positionCeo = new Position("CEO", 500000);
        Position positionHR = new Position("HR", 150000);
        Position positionQ = new Position("Quality", 75000);
        positions.add(positionCeo);
        positions.add(positionHR);
        positions.add(positionQ);

        for (Position item : positions) {
            if(item.getBonus() > 150000) {
                System.out.println(item);
            }
        }
    }

    @Override
    public String toString() {
        return "Position: " + name + ", Bonus: " + bonus;
    }
}
