package covid;

import java.time.LocalDateTime;

public class Citizen {

    private int id;
    private String fullName;
    private String postCode;
    private byte age;
    private String email;
    private String tajId;
    private byte numberOfVaccination;
    private LocalDateTime lastVaccinationDateTime;
    private VaccineType vaccineType;

    public Citizen(String fullName, String postCode, byte age, String email, String tajId) {
        this.fullName = Validator.nameValidator(fullName);
        this.postCode = Validator.zipValidator(postCode);
        this.age = Validator.ageValidator(age);
        this.email = Validator.emailValidator(email);
        this.tajId = Validator.tajValidator(tajId);
    }

    public Citizen(int id, String fullName, String postCode, byte age, String email, String tajId, byte numberOfVaccination, LocalDateTime lastVaccinationDateTime) {

        this.id = id;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDateTime = lastVaccinationDateTime;
    }

    public Citizen(int id, String fullName, String postCode, byte age, String email, String tajId, byte numberOfVaccination, LocalDateTime lastVaccinationDateTime, VaccineType vaccineType) {
        this(fullName, postCode, age, email, tajId);
        this.id = id;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDateTime = lastVaccinationDateTime;
        this.vaccineType = vaccineType;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPostCode() {
        return postCode;
    }

    public byte getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTajId() {
        return tajId;
    }

    public int getId() {
        return id;
    }

    public byte getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDateTime getLastVaccinationDateTime() {
        return lastVaccinationDateTime;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", postCode=" + postCode +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", tajId='" + tajId + '\'' +
                ", numberOfVaccination=" + numberOfVaccination +
                ", lastVaccinationDateTime=" + lastVaccinationDateTime +
                '}';
    }
}
