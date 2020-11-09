package typeconversion.dataloss;

public class DataLoss {

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();
        dataLoss.dataLoss();
    }

    public void dataLoss() {
        long floatMaxToLong = (long) (Float.MAX_VALUE);
        long first = floatMaxToLong + 1;
        long sec = floatMaxToLong + 2;
        long third = floatMaxToLong + 3;

        float f = (float) first;
        float f2 = (float) sec;
        float f3 = (float) third;

        long convertedFirst = (long) f;
        long convertedSec = (long) f2;
        long convertedThird = (long) f3;

        //System.out.println(floatMaxToLong); //Ezt push előtt kikommentelni
        System.out.println(convertedFirst);
        System.out.println(convertedSec);
        System.out.println(convertedThird);

        //System.out.println(Long.toBinaryString(floatMaxToLong)); //Ezt push előtt kikommentelni
        System.out.println(Long.toBinaryString(convertedFirst));
        System.out.println(Long.toBinaryString(convertedSec));
        System.out.println(Long.toBinaryString(convertedThird));
    }

}
