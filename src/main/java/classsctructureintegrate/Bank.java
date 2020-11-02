package classsctructureintegrate;

public class Bank {

    public static void main(String[] args) {
        BankAccount person1 = new BankAccount("123456789","Geletei Krisztián",250000);
        BankAccount person2 = new BankAccount("987654321","John Doe",400000);

        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());

        person1.deposit(140000);
        person2.deposit(50000);

        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());

        person1.withDraw(410000);
        person2.withDraw(100000);

        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());

        person2.transfer(person1,20000);

        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());

    }
}
