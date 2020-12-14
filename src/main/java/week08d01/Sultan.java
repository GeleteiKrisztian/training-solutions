package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {

    public static final int DOOR_NUM = 100;
    private boolean[] doorsArray = new boolean[DOOR_NUM];

    public List<Boolean> openDoors() {
        List<Boolean> doors = new ArrayList<>();

        for (int i = 0; i < DOOR_NUM; i++) {
            for (int j = i; j < DOOR_NUM; j+=i+1) {
                doorsArray[j] = !doorsArray[j];
            }
        }

        for (int i = 0;i < DOOR_NUM; i++) {
            doors.add(doorsArray[i]);
        }
        return doors;
    }

}
