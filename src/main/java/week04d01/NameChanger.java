package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName) {
        if (isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("Invalid name: " + firstName);
        }
        fullName = firstName + " " + fullName.split(" ")[1];
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

}

