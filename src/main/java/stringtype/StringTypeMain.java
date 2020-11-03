package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message += 444;
        boolean b = "Hello John Doe".equals(message);
        System.out.println(b);
        boolean c = "Hello John Doe444".equals(message);
        System.out.println(c);
        String s = "" + "";
        System.out.println(s);
        System.out.println(s.length());

        String s1 = "Abcde";
        System.out.println(s1.length());
        System.out.println(s1.substring(0,1));
        System.out.println(s1.substring(2,3));
        System.out.println(s1.substring(0,3));

    }
}
