package operators;

public class OperatorsMain {

    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println("Páros-e: " + operators.isEven(14));
        System.out.println("Páros-e: " + operators.isEven(13));

        System.out.println(16 >> 1);
        System.out.println(16 << 1);
        System.out.println(13 >> 1);
        System.out.println(13 << 1);

        operators.multiplyByPowerOfTwo(10,5);

    }
}
