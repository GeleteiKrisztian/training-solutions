package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person1,person2;

        person1 = new Person("John Wick",29);
        person2 = person1;

        person2.setName("Johnie Wick");
        System.out.println(person1.getName());
        System.out.println(person2.getName());

        int num1,num2;
        num1 = 24;
        num2 = num1;
        num2 = num2 + 1;
        System.out.println(num1 + " " + num2);

        person2 = new Person("Jack Doe",28);
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
