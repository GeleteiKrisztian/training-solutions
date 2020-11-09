package array.primitivetypes;

public class PrimitiveTypes {

    public String toBinaryStringSajat(int n) {
        int intForLoop = 32;
        String s = "";
        boolean nIsNegative = false;

        if (n < 0) {
            nIsNegative = true;
            n=-n;
        }

        for (int i = 0; n > 0; i++ ) {

            int maradek = n % 2;
            n /= 2;
            s = maradek + s;

        }

        int sLength = s.length();
        for (int i = 0; i < (intForLoop - sLength); i++) {
            s = "0" + s;
        }
        return nIsNegative ? ("-" + s) : s;
    }

    public String toBinaryString(int n) {
        return Integer.toString(n,2);
    }

}
