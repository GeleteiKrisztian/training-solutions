package attributes.person;

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person("John Wick","123456789");
        Address address = new Address("Hungary","Budapest", "John Wick út 123", "1119");
        person.moveTo(address);
        System.out.println(person.getAddress().addressToString());

        System.out.println(person.personToString());
        person.correctData("Johnie Wick","0123456789");
        System.out.println(person.personToString());

        address.correctData("Hungary","Budapest", "John Wick út 321", "1119");
        person.moveTo(address);
        System.out.println(person.getAddress().addressToString());
    }
}
