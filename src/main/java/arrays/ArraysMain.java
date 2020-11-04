package arrays;
// Ezt azért importálom,mert az előző leckéből szükségem van a hónapok napjának számára
import arrayofarrays.ArrayOfArraysMain;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = new int[12];
        //Az importnál említett osztály,ami tartalmazza a hónapok napjainak számát
        ArrayOfArraysMain arrOfArr = new ArrayOfArraysMain();

        int [][] arrOfArrReturn = arrOfArr.getValues();
        //ezzel a ciklussal rengeteg időt és kódolást megspóroltam,de működik :D
        //a hónapok napjait tároló int tömböt aoutomatikusan feltölti,az előző lecke tömbjének a tömbjeinek hosszából
        for (int i = 0;i < numberOfDays.length;i++) {
            numberOfDays[i] = arrOfArrReturn[i].length;
        }
        String returnData = Arrays.toString(numberOfDays);
        return returnData;
    }

    public List<String> daysOfWeek() {
        String[] arrString = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        return Arrays.asList(arrString);
    }

    public String multiplicationTableAsString(int size) {
        ArrayOfArraysMain arrOfArr = new ArrayOfArraysMain();
        int[][] arrayOfArrayInt = arrOfArr.multiplicationTable(size);
        return Arrays.deepToString(arrayOfArrayInt);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day,anotherDay);
    }

    public boolean wonLottery(int[] myTicketNumbers, int[] lotteryNumbers) {
       int[] copyMyTicket = Arrays.copyOf(myTicketNumbers,myTicketNumbers.length);
        int[] copyLottery = Arrays.copyOf(lotteryNumbers,lotteryNumbers.length);

        Arrays.sort(copyMyTicket);
        Arrays.sort(copyLottery);
        return Arrays.equals(copyMyTicket,copyLottery);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println("A hónapok napjai Stringként visszaadva: " + arraysMain.numberOfDaysAsString());

        System.out.println("A tömb tömbjei visszadva szövegesen: " + arraysMain.multiplicationTableAsString(5));

        double[] firstMeasureData = {0.0, 0.5, 1.1, 2.4, 10.0};
        double[] secondMeasureData = {0.5, 1.1, 10.0, 2.4, 0.0};

        Arrays.sort(firstMeasureData);
        Arrays.sort(secondMeasureData);
        System.out.println("A mért értékek két tömbje megegyezik: " + arraysMain.sameTempValues(firstMeasureData,secondMeasureData));

        int[] otosLottoSzamaim = {2, 5, 7, 9, 10};
        int[] kisorsoltSzamok = {3, 5, 7, 9, 10};

        System.out.println("A kisorsolt számok és a szelvény számai megegyeznek: " + arraysMain.wonLottery(otosLottoSzamaim,kisorsoltSzamok));
    }
}
