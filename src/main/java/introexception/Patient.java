package introexception;

import java.time.LocalDate;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        boolean isValidTAJ = true;

        try {
            isValidTAJ = new SsnValidator().isValidSsn(socialSecurityNumber);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Hiba! Üzenet: " + ex.getMessage());
        }

        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("Hibás argumentum. A név nem lehet üres. name = \"" + name + "\"");
        }

        if (!isValidTAJ || socialSecurityNumber.length() != 9){
            throw new IllegalArgumentException("Hibás argumentum. A TAJ azonosítószáma nem felel meg a követelményeknek,vagy a hossza nem megfelelő! TAJ = " + socialSecurityNumber);
        }

        if (yearOfBirth < 1900 || yearOfBirth > LocalDate.now().getYear()){
            throw new IllegalArgumentException("Hibás argumentum(ok). Az év értéke nem lehet kisebb,mint 1900 vagy nagyobb,a jelenlegi évtől! Év = \"" + yearOfBirth + "\"");
        }

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public static void main(String[] args) {
        Patient patient = new Patient("John Wick","123456788",1995);
        System.out.println(patient);
    }
}
