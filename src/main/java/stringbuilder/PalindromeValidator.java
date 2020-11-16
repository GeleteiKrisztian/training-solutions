package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        isEmptyOrBlank(word);
        String reverseString = new StringBuilder(word).reverse().toString().trim();
        if (word.trim().equalsIgnoreCase(reverseString)) {
            return true;
        }
        return false;
    }

    private boolean isEmptyOrBlank(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        return false;
    }

}
