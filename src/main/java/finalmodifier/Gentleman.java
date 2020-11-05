package finalmodifier;

public class Gentleman {

    private final String MESSAGE_PREFIX = "Hi ";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name + "!";
    }

    public static void main(String[] args) {
        Gentleman gent = new Gentleman();
        System.out.println(gent.sayHello("Chris"));
    }
}
