package week03;

public class PhoneParse {

    public Phone parse(String number) {
        String[] split = number.split("-");
        Phone phone = new Phone(split[0],split[1]);
        return phone;
    }

    public static void main(String[] args) {
        PhoneParse phoneParse = new PhoneParse();
        Phone phone = phoneParse.parse("30-3040400");
        System.out.println("A prefix: " + phone.getPrefix() + ", a számjegyek: " + phone.getNumber());
    }
}
