package stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        return new String("John Wick");
    }

    public String createStringForPool() {
        return "John Wick".intern();
    }

    public static void main(String[] args) {
        StringCreator stringCreator = new StringCreator();
        String s1 = stringCreator.createStringForHeap();
        String s2 = stringCreator.createStringForPool();
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

    }
}
