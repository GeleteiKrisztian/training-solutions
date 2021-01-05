package exceptionmulticatch;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String s) {
        if (s == null) {
            throw new NullPointerException("binaryString null");
        }
        boolean[] booleans = new boolean[s.length()];
        try {
            for (int i = 0; i < s.length(); i++) {
               booleans[i] = parseBool(s.charAt(i));
                //booleans[i] = ('1' == s.charAt(i));
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("binaryString not valid", nfe);
        }
        return booleans;
    }

    public String booleanArrayToBinaryString(boolean[] bools) {
        if (bools.length == 0) {
            throw new IllegalArgumentException("");
        }
        StringBuilder sb = new StringBuilder();
        for (boolean item : bools) {
            if (item == false) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    private boolean parseBool(char c) {
        String str = String.valueOf(c);
        if (c == '1') {
            return true;
        } else if (c == '0') {
            return false;
        } else
            throw new NumberFormatException("");
    }

}
