package stringbasic.pet;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    public void add(Pet pet) {
        if (!areEquals(pet)) {
            pets.add(pet);
        }
    }

    private boolean areEquals(Pet pet) {
        for (Pet item : pets) {
            if (item.getRegNumber().equals(pet.getRegNumber())) {
                return true;
            }
        }
        return false;
    }

    public List<Pet> getPets() {
        return pets;
    }

}
