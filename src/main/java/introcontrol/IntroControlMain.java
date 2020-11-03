package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl introC = new IntroControl();
        System.out.println(introC.substractTenIfGreaterThanTen(100));
        System.out.println(introC.substractTenIfGreaterThanTen(10));

        System.out.println(introC.describeNumber(1));
        System.out.println(introC.describeNumber(0));

        System.out.println(introC.greetingToJoe("Joe"));
        System.out.println(introC.greetingToJoe("Jack"));

        System.out.println(introC.calculateBonus(1000000));
        System.out.println(introC.calculateBonus(10000));

        System.out.println(introC.calculateConsumption(3333,9999));
        System.out.println(introC.calculateConsumption(9999,3333));

        introC.printNumbers(11);
        introC.printNumbersBetween(5,30);
        introC.printNumbersBetweenAnyDirection(1,9);
        introC.printNumbersBetweenAnyDirection(9,1);
        introC.printOddNumbers(16);
    }
}
