package algorithmsmax;

import java.util.ArrayList;
import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer trainer = null;
        for (Trainer item : trainers) {
            if (trainer == null || item.getAge() > trainer.getAge()) {
                trainer = item;
            }
        }
        return trainer;
    }

}
