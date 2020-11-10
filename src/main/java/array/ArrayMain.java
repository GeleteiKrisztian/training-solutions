package array;

public class ArrayMain {

    public static void main(String[] args) {

        String[] arrString = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println("A tömb második eleme: " + arrString[1] + ". A tömb hossza: " + arrString.length);

        int[] arrInt = new int[5];
        int powerStart = 1;
        arrInt[0] = powerStart;

        for (int i = 1;i < arrInt.length;i++) {
            arrInt[i] = powerStart *= 2;
        }

        for (int item : arrInt) {
            System.out.println(item);
        }


        boolean[] booleans = new boolean[6];
        for (int i = 1;i < 6;i++) {
            if (i % 2 == 0) {
                booleans[i] = false;
            } else
                booleans[i] = true;
        }

        for (boolean bool : booleans) {
            System.out.println(bool);
        }

    }
}
