package unnamed;

public class PiSzamlalo {

    public static void main(String[] args) {
        String piNum = "";
        int counter = 0;
        String poem = "Nem a régi s durva közelítés," +
                "Mi szótól szóig így kijön " +
        "Betűiket számlálva." +
        "Ludolph eredménye már," +
                "Ha itt végezzük húsz jegyen." +
        "De rendre kijő még tíz pontosan," +
        "Azt is bízvást ígérhetem.";

        for (int i = 0; i < poem.length(); i++) {
            if(piNum.length() == 1) {
                piNum = piNum + ".";
            }
            if(poem.charAt(i) == ' ' || poem.charAt(i) == ',' || poem.charAt(i) == '.') {
                piNum += counter;
                counter = 0;
            } else {
                counter++;
            }
        }
        System.out.println(poem);
        System.out.println(piNum);

    }
}
