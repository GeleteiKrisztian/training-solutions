package pet;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate bornDate;
    private Gender gender;
    private String regNumber;

    public Pet(String name, LocalDate bornDate, Gender gender, String regNumber) {
        this.name = name;
        this.bornDate = bornDate;
        this.gender = gender;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegNumber() {
        return regNumber;
    }

}
