package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int [][] arrOfArr = new int[size][size];
                for (int i = 0;i < arrOfArr.length;i++) {
                    for (int j = 0;j < arrOfArr[i].length;j++) {
                        arrOfArr[i][j] = (i+1) * (j+1);
                    }
                }
                return arrOfArr;
        }

    public void printArrayOfArrays(int[][] a) {
        for (int i = 0;i < a.length;i++) {
            for (int j = 0;j< a[i].length;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrOfArrMain = new ArrayOfArraysMain();
        int[][] arrOfArr = arrOfArrMain.multiplicationTable(4);
        arrOfArrMain.printArrayOfArrays(arrOfArr);
    }
}
