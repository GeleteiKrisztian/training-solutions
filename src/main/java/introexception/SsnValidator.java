package introexception;

public class SsnValidator {

    public boolean isValidSsn(String ssn) throws NumberFormatException,IndexOutOfBoundsException {
        int oddsAndEvensSum = 0;

        for (int i = 0; i < ssn.length() - 1; i += 2) {
            oddsAndEvensSum += Integer.parseInt(String.valueOf(ssn.charAt(i))) * 3;
        }

        for (int i = 1; i < ssn.length() - 1; i +=2) {
            oddsAndEvensSum += Integer.parseInt(String.valueOf(ssn.charAt(i))) * 7;
        }

        boolean isValid = Integer.toString(oddsAndEvensSum % 10).equals(String.valueOf(ssn.charAt(8)));
        return isValid;
    }
}
