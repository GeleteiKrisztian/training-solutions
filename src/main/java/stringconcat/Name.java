package stringconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        if(familyName == null || "".equals(familyName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if (givenName == null || "".equals(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public boolean isEmpty(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        return false;
    }

    public String concatNameWesternStyle() {
        if (title == null) {
            return givenName + " " + middleName + " " + familyName;
        }
        return title.name().substring(0, 1).toUpperCase() + title.name().substring(1).toLowerCase() + ". " + givenName + " " + middleName + " " + familyName;
    }

    public String concatNameHungarianStyle() {
        if (title == null) {
            return familyName.concat(" ").concat(middleName).concat(" ").concat(givenName);
        }
        return title.name().substring(0, 1).toUpperCase() + title.name().substring(1).toLowerCase().concat(". ").concat(familyName).concat(" ").concat(middleName).concat(" ").concat(givenName);
    }

}
