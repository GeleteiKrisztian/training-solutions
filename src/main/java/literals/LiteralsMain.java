package literals;

public class LiteralsMain {

    public static void main(String[] args) {
        String s = 1 + "" + 2;
        System.out.println(s);

        double quotient = 3 / 4;
        System.out.println(quotient);

        quotient = 3 / 4.0;
        System.out.println(quotient);
        quotient = 3 / 4D;
        System.out.println(quotient);

        long big = 3_244_444_444L;
        System.out.println(big);

        String s2 = "árvíztűrőtükörfúrógép";
        System.out.println(s2);

        String word = "title".toUpperCase();
        System.out.println(word);

        Integer integer = 1;
        System.out.println(Integer.toString(integer,2));
        integer = -2;
        System.out.println(Integer.toBinaryString(integer));

    }
}
