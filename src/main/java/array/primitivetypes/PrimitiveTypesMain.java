package array.primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
        int num = -13;

        String integerToBinaryString = Integer.toBinaryString(num);

        System.out.println(primitiveTypes.toBinaryStringSajat(num));
        System.out.println(primitiveTypes.toBinaryString(num));
        System.out.println(primitiveTypes.toBinaryString(num).equals(integerToBinaryString));

    }
}
