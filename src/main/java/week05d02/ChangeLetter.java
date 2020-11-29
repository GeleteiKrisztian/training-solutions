package week05d02;

public class ChangeLetter {

    private final String VOWELS = "aeiou";

    public String changeVowels(String s) {
        isNullOrEmpty(s);
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            found = false;
            for (int j = 0; j < VOWELS.length(); j++) {
                if (s.charAt(i) == VOWELS.charAt(j)) {
                    sb.append("*");
                    found = true;
                    break;
                }
            }
            if (found == false) {
            sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private void isNullOrEmpty(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Argument is null or empty!");
        }
    }

}
