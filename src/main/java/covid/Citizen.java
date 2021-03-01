package covid;

import java.time.LocalDateTime;

public class Citizen {

    private int id;
    private String fullName;
    private int postCode;
    private byte age;
    private String email;
    private String tajId;
    private byte numberOfVaccination;
    private LocalDateTime lastVaccinationDateTime;

    public Citizen(String fullName, int postCode, byte age, String email, String tajId) {
        this.fullName = fullName;
        this.postCode = postCode;
        this.age = age;
        this.email = email;
        this.tajId = tajId;
    }

    public Citizen(int id, String fullName, int postCode, byte age, String email, String tajId, byte numberOfVaccination, LocalDateTime lastVaccinationDateTime) {
        this.id = id;
        this.fullName = fullName;
        this.postCode = postCode;
        this.age = age;
        this.email = email;
        this.tajId = tajId;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDateTime = lastVaccinationDateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPostCode() {
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
